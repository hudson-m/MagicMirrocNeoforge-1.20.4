package com.hudshow.neoforge.item;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MagicMirrorItem extends Item {

    public MagicMirrorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            // 1. Obter a posição de spawn do jogador
            BlockPos spawnPos = getSpawnPosition(serverPlayer);

            // 2. Teleportar o jogador
            teleportToSpawn(serverPlayer, spawnPos);

            // 3. Feedback visual e sonoro
            sendTeleportFeedback(serverPlayer);

            // 4. Opcional: consumir o item
            // itemStack.shrink(1);

            // 5. Opcional: cooldown
            // player.getCooldowns().addCooldown(this, 20 * 5); // 5 segundos
        }

        return InteractionResultHolder.success(itemStack);
    }

    private BlockPos getSpawnPosition(ServerPlayer player) {
        // Tenta pegar o spawn pessoal do jogador
        BlockPos spawnPos = player.getRespawnPosition();

        // Se não tiver spawn definido, usa o spawn global do mundo
        if (spawnPos == null) {
            spawnPos = player.server.getLevel(Level.OVERWORLD).getSharedSpawnPos();
        }

        return spawnPos;
    }

    private void teleportToSpawn(ServerPlayer player, BlockPos spawnPos) {
        player.teleportTo(
                player.server.getLevel(Level.OVERWORLD), // Dimensão (Overworld)
                spawnPos.getX() + 0.5,  // Centraliza no bloco
                spawnPos.getY(),
                spawnPos.getZ() + 0.5,  // Centraliza no bloco
                player.getYRot(),       // Mantém a rotação atual
                player.getXRot()        // Mantém a inclinação atual
        );
    }

    private void sendTeleportFeedback(Player player) {
        // Mensagem no chat
        player.sendSystemMessage(Component.literal("Teleportado para o spawn inicial!"));

        // Efeito sonoro (opcional)
        // player.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 1.0F, 1.0F);

        // Partículas (opcional, precisa ser no lado do servidor)
        // if (player.level() instanceof ServerLevel serverLevel) {
        //     serverLevel.sendParticles(ParticleTypes.PORTAL,
        //         player.getX(), player.getY(), player.getZ(),
        //         50, 1, 1, 1, 0.5);
        // }
    }
}

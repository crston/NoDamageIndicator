package com.gmail.bobason01;

import org.bukkit.Particle;
import org.bukkit.event.Listener;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedParticle;


public class nodamageindicator extends main implements Listener {
    public void onLoad() {
        ProtocolManager manager = ProtocolLibrary.getProtocolManager();
        manager.addPacketListener(new PacketAdapter(this, ListenerPriority.NORMAL, new PacketType[]{Server.WORLD_PARTICLES}) {
            public void onPacketSending(PacketEvent event) {
                PacketContainer packet = event.getPacket();
                if (event.getPacketType() == Server.WORLD_PARTICLES) {
                    if (((WrappedParticle)packet.getNewParticles().read(0)).getParticle() == Particle.DAMAGE_INDICATOR) {
                        event.setCancelled(true);
                    }

                }
            }
        });
    }
}
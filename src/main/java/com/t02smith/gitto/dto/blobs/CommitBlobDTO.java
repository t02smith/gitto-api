package com.t02smith.gitto.dto.blobs;

import java.time.LocalDateTime;

/**
 *
 * @param hash the commits hash
 * @param author who pushed the commit
 * @param message the commit message
 * @param parentHash the previous commit
 * @param timestamp when the commit happened
 * @param treeHash the corresponding tree
 */
public record CommitBlobDTO(
        String hash,
        String author,
        String message,
        String parentHash,
        LocalDateTime timestamp,
        String treeHash
) {
}

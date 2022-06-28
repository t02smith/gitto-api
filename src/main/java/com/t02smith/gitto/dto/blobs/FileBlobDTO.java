package com.t02smith.gitto.dto.blobs;

/**
 * Represents metadata about a file
 * Will be sent before the compressed file is sent
 */
public record FileBlobDTO(
        String hash, String name, String treeHash
) {
}

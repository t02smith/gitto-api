package com.t02smith.gitto.dto.blobs;

import java.util.List;

/**
 * Presents a minimal tree to send
 * Assumes that the entirety of the tree is sent so parent is excluded
 * as all nodes will be present in the trees field
 *
 * @param hash the tree's hash
 * @param name the directory name
 * @param files list of file hashes
 * @param trees recursive list of tree DTOs
 */
public record TreeBlobDTO(
        String hash,
        String name,
        List<String> files,
        List<TreeBlobDTO> trees
) {
}

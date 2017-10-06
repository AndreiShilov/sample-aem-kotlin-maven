package com.asd.aem.ktln.core.models;

import com.day.cq.dam.api.Asset;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.inject.Inject;

/**
 * @author andre
 */
@Model(adaptables = Resource.class)
public class BluredImageModel {

    @Inject
    private String fileReference;

    @Inject
    private ResourceResolver resourceResolver;

    private String smallImagePath;
    private int width;
    private int height;

    @PostConstruct
    private void init() throws IOException {

        if (fileReference == null) {
            return;
        }
        Resource resource = resourceResolver.getResource(fileReference);

        if (resource == null) {
            return;
        }

        Asset asset = resource.adaptTo(Asset.class);

        if (asset == null) {
            return;
        }

        BufferedImage bufferedImage = ImageIO.read(asset.getOriginal().getStream());

        this.width = bufferedImage.getWidth();
        this.height = bufferedImage.getHeight();

        this.smallImagePath = createSmallPath();
    }

    private String createSmallPath() {
        return this.fileReference +".transform/small/image.png";
    }

    public String getSmallImagePath() {
        return smallImagePath;
    }

    public String getOriginalImagePath() {
        return fileReference;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

SUMMARY = "A console-only image with a development/debug \
environment suitable for building GNURadio out of tree blocks installed."

require version-image.inc

IMAGE_FEATURES += "splash ssh-server-openssh \
                   tools-debug debug-tweaks \
                    \
                  "

EXTRA_IMAGE_FEATURES += "package-management"

LICENSE = "MIT"

require recipes-images/images/native-sdk.inc

CORE_IMAGE_EXTRA_INSTALL = "\
    packagegroup-sdr-base-extended \
    packagegroup-sdr-base-debug \
    packagegroup-sdr-base-devel \
    packagegroup-sdr-base-python \
    packagegroup-sdr-python-extended \
    packagegroup-sdr-gnuradio-base \
    packagegroup-sdr-hardware \
    packagegroup-core-eclipse-debug \
    xauth \
    e2fsprogs-resize2fs \
    "

#    zeroc-ice 

inherit core-image image-buildinfo

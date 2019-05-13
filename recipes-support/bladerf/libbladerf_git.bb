SUMMARY = "Nuand bladeRF library and associatied utilities"
HOMEPAGE = "http://www.nuand.com"
BUGTRACKER = "https://github.com/nuand/bladeRF/issues"

# libbladeRF is licensed under LGPLv2.1
# The utilities built atop of it are licensed under GPLv2
LICENSE = "LGPLv2.1 & GPLv2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=216d4da529e4bd450bed41e78930f1ba\
    file://legal/licenses/LICENSE.GPLv2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://legal/licenses/LICENSE.LGPLv2.1;md5=4b54a1fd55a448865a0b32d41598759d \
    "

PV = "2.2.0-git-8a4d95c"

DEPENDS = "libusb1 libedit patch-native"

SRC_URI = "gitsm://github.com/Nuand/bladeRF.git;protocol=git;branch=master"
SRCREV = "896d2431b3a35a4b31b6e729386202ebf5fdc5c0"

S = "${WORKDIR}/git"

inherit pkgconfig cmake lib_package

EXTRA_OECMAKE += "\
    -DCMAKE_INSTALL_PREFIX=/usr \
    -DUDEV_RULES_PATH=${sysconfdir}/udev/rules.d \
"

# The libbladeRF build process applies patches to the upstream libad936x
# library. However, the FindPatcher does not find out tmp/hosttools/patch
# binary. Disable this and force it to use the "patch" binary that's
# already in $PATH.
EXTRA_OECMAKE += "\
    -DCMAKE_DISABLE_FIND_PACKAGE_Patch=True \
    -DPatch_FOUND=True \
    -DPatch_EXECUTABLE=patch \
"

LIBBLADERF_MAJOR_VER ?= "2"
FILES_${PN}${LIBBLADERF_MAJOR_VER} += "${libdir} ${sysconfdir}/udev/rules.d"
FILES_${PN}-bin = "${bindir}"

RDEPENDS_${PN} += "bladerf-fpga"
RDEPENDS_${PN}-bin += "libedit"

SUMMARY = "Pre-built FPGA bitstreams for the Nuand bladeRF"
HOMEPAGE = "http://www.nuand.com"
BUGTRACKER = "https://github.com/nuand/bladeRF/issues"

# The Nuand HDL is MIT-licensed, so we'll point to the matching portions of
# the license text from the common license directory, as to not require
# checking out an entire codebase just for the license file.
#
# The original license text is available at:
#   https://raw.githubusercontent.com/Nuand/bladeRF/master/legal/licenses/LICENSE.MIT.nuand
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;beginline=6;endline=22;md5=838c366f69b72c5df05c96dff79b35f2"

SRC_URI = "https://www.nuand.com/fpga/v${PV}/hostedx40.rbf;name=x40 \
           https://www.nuand.com/fpga/v${PV}/hostedx115.rbf;name=x115 \
           https://www.nuand.com/fpga/v${PV}/hostedxA4.rbf;name=a4 \
           https://www.nuand.com/fpga/v${PV}/hostedxA9.rbf;name=a9 \
          "

SRC_URI[x40.md5sum]     = "4aabf1617901423569f425db93598884"
SRC_URI[x40.sha256sum]  = "ab4872a894459ee37e61de92bd502d904c5971acc826f2035d9c8793b88f3824"

SRC_URI[x115.md5sum]    = "33641f8a126bef1c0b7e6ba8bedda93f"
SRC_URI[x115.sha256sum] = "5f0c5221d18138ec5f56c24de16e33469c2d3725ac21e2445e6b64edf789013b"

SRC_URI[a4.md5sum]      = "b3f8b37fccee3eacb85aeb4f9fe89b2b"
SRC_URI[a4.sha256sum]   = "968a6eab717cd03977a64ebec517b287f1fb463700d32f6e0933f3e119673621"

SRC_URI[a9.md5sum]      = "f4833d63f594b0a8c51c579d6f72181e"
SRC_URI[a9.sha256sum]   = "d877f01bff9162d673465b0bf0357daace72beebf835e8ad5ae78eef05f4d9f4"

S = "${WORKDIR}"

do_configure() {
}

do_compile() {
}

do_install() {
    install -d ${D}${datadir}/Nuand/bladeRF
    install -m 0644 ${S}/hostedx40.rbf ${D}${datadir}/Nuand/bladeRF/hostedx40.rbf
    install -m 0644 ${S}/hostedx115.rbf ${D}${datadir}/Nuand/bladeRF/hostedx115.rbf
    install -m 0644 ${S}/hostedxA4.rbf ${D}${datadir}/Nuand/bladeRF/hostedxA4.rbf
    install -m 0644 ${S}/hostedxA9.rbf ${D}${datadir}/Nuand/bladeRF/hostedxA9.rbf
}

PACKAGES = "${PN}"
FILES_${PN} = "${datadir}/Nuand/bladeRF"

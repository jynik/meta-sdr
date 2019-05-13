SUMMARY    = "Real-time GPS Simulator for the bladeRF"
HOMEPAGE   = "https://github.com/osqzss/bladeGPS"
BUGTRACKER = "https://github.com/osqzss/bladeGPS/issues"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;beginline=6;endline=22;md5=838c366f69b72c5df05c96dff79b35f2"

SRC_URI = "git://github.com/osqzss/bladeGPS.git"
SRCREV =  "6691d64f2612e8722cd8371fd0837dc36838fbe0"

DEPENDS = "libbladerf"
RDEPENDS_${PN} = "bladerf-fpga"

S="${WORKDIR}/git"
B="${WORKDIR}/build"

do_compile() {
    ${CC} ${CFLAGS} -Wall -O3 ${S}/bladegps.c ${S}/gpssim.c ${LDFLAGS} -lm -pthread -lbladeRF -o ${B}/bladegps
}

do_install() {
    install -d ${D}${bindir}
    install -m 0644 ${B}/bladegps ${D}${bindir}/bladegps
}

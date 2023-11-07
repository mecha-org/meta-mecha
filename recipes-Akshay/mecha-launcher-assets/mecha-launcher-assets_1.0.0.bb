DESCRIPTION = "Mecha-launcher service assets"
SUMMARY = "mecha-launcher"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI =   "file://mecha-launcher-assets \
             file://mecha-launcher-settings \
            "

S = "${WORKDIR}"


do_install() {
    install -d ${D}${sysconfdir}
    cp -r ${WORKDIR}/mecha-launcher-assets ${D}${sysconfdir}
    cp -r ${WORKDIR}/mecha-launcher-settings ${D}${sysconfdir}
}

FILES:${PN} += "/etc/mecha-lanucher-assets/*"
FILES:${PN} += "/etc/mecha-lanucher-settings/*"

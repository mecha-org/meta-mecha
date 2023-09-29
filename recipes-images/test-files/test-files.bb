DESCRIPTION = "Media Test files audio,video & images"
SUMMARY = "Media files for test"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI =   "file://media-files/abcaudiosample48.mp3 \
             file://media-files/abcaudiosample48.wav \
             file://media-files/image01.jpg \
             file://media-files/image02.jpg \
             file://media-files/image03.jpg \
             file://media-files/mecha-background.png \
             file://media-files/sample1_16.wav \
             file://media-files/sample32.mp3 \
             file://media-files/SampleVideo_720x480_30mb.mp4 \
             file://media-files/wildlife.mp4 \
            "

S = "${WORKDIR}"

do_install() {
    install -d ${D}/home/mecha/media-files/
    install -m 0775 ${WORKDIR}/media-files/abcaudiosample48.mp3         ${D}/home/mecha/media-files/abcaudiosample48.mp3
    install -m 0775 ${WORKDIR}/media-files/abcaudiosample48.wav         ${D}/home/mecha/media-files/abcaudiosample48.wav
    install -m 0775 ${WORKDIR}/media-files/dua-lipa44.mp3               ${D}/home/mecha/media-files/dua-lipa44.mp3
    install -m 0775 ${WORKDIR}/media-files/dua-lipa44.wav               ${D}/home/mecha/media-files/dua-lipa44.wav 
    install -m 0775 ${WORKDIR}/media-files/dua-lipa48.mp3               ${D}/home/mecha/media-files/dua-lipa48.mp3
    install -m 0775 ${WORKDIR}/media-files/image01.jpg                  ${D}/home/mecha/media-files/image01.jpg
    install -m 0775 ${WORKDIR}/media-files/image02.jpg                  ${D}/home/mecha/media-files/image02.jpg
    install -m 0775 ${WORKDIR}/media-files/image03.jpg                  ${D}/home/mecha/media-files/image03.jpg
    install -m 0775 ${WORKDIR}/media-files/mecha-background.png         ${D}/home/mecha/media-files/mecha-background.png
    install -m 0775 ${WORKDIR}/media-files/sample1_16.wav               ${D}/home/mecha/media-files/sample1_16.wav
    install -m 0775 ${WORKDIR}/media-files/sample32.mp3                 ${D}/home/mecha/media-files/sample32.mp3
    install -m 0775 ${WORKDIR}/media-files/SampleVideo_720x480_30mb.mp4 ${D}/home/mecha/media-files/SampleVideo_720x480_30mb.mp4
    install -m 0775 ${WORKDIR}/media-files/wildlife.mp4                 ${D}/home/mecha/media-files/wildlife.mp4
}
INSANE_SKIP_${PN}:append = "already-stripped"
FILES:${PN} += "/home/mecha/*"

#   install -d ${D}/${ROOT_HOME}/media-files/
#   FILES:${PN} += "${ROOT_HOME}/*"

#   ROOT_HOME="/home/root"

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
             file://media-files/sampleaudio_16.wav \
             file://media-files/sampleaudio_32.mp3 \
             file://media-files/samplevideo_720x480.mp4 \
             file://media-files/samplevideo_wildlife.mp4 \
             file://config.yaml \
            "

S = "${WORKDIR}"

do_install() {
    install -d ${D}/MECHA_TEST/media-files/
    install -m 0775 ${WORKDIR}/media-files/abcaudiosample48.mp3         ${D}/MECHA_TEST/media-files/abcaudiosample48.mp3
    install -m 0775 ${WORKDIR}/media-files/abcaudiosample48.wav         ${D}/MECHA_TEST/media-files/abcaudiosample48.wav
    install -m 0775 ${WORKDIR}/media-files/image01.jpg                  ${D}/MECHA_TEST/media-files/image01.jpg
    install -m 0775 ${WORKDIR}/media-files/image02.jpg                  ${D}/MECHA_TEST/media-files/image02.jpg
    install -m 0775 ${WORKDIR}/media-files/image03.jpg                  ${D}/MECHA_TEST/media-files/image03.jpg
    install -m 0775 ${WORKDIR}/media-files/mecha-background.png         ${D}/MECHA_TEST/media-files/mecha-background.png
    install -m 0775 ${WORKDIR}/media-files/sampleaudio_16.wav           ${D}/MECHA_TEST/media-files/sampleaudio_16.wav
    install -m 0775 ${WORKDIR}/media-files/sampleaudio_32.mp3           ${D}/MECHA_TEST/media-files/sampleaudio_32.mp3
    install -m 0775 ${WORKDIR}/media-files/samplevideo_720x480.mp4      ${D}/MECHA_TEST/media-files/samplevideo_720x480.mp4
    install -m 0775 ${WORKDIR}/media-files/samplevideo_wildlife.mp4     ${D}/MECHA_TEST/media-files/samplevideo_wildlife.mp4
    install -m 0755 ${WORKDIR}/config.yaml ${D}/MECHA_TEST/
}
INSANE_SKIP_${PN}:append = "already-stripped"
FILES:${PN} += "/MECHA_TEST/*"


#   install -d ${D}/${ROOT_HOME}/media-files/
#   FILES:${PN} += "${ROOT_HOME}/*"

#   ROOT_HOME="/home/root"

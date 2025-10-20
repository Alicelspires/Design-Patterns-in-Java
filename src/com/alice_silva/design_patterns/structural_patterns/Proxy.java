package com.alice_silva.design_patterns.structural_patterns;

/*
 * Um serviço de streaming precisa controlar o acesso aos vídeos 
 * de seu catálogo. O sistema possui uma classe VideoService que 
 * realiza o carregamento e exibição dos vídeos.
 * No entanto, o carregamento é pesado e demorado, e o sistema deve 
 * restringir o acesso a usuários não autenticados.
 */

interface Service {
    void showVideo();
}

class VideoService implements Service {
    private String video;

    public VideoService(String video){
        this.video = video;
    }

    public void carregamento(){
        try{
            System.out.printf("Carregando video: %s ...\n", this.video);
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void showVideo(){
        System.out.println("Vídeo carregado com sucesso!");
    }
}

class VideoProxy implements Service {
    private boolean autenticado;
    private VideoService video;
    private String infoVideo;

    public VideoProxy(String infoVideo, boolean autenticado){
        this.infoVideo = infoVideo;
        this.autenticado = autenticado;
    }

    public void showVideo(){
        if(!this.autenticado){
            System.out.println("Acesso negado!\n");
        } else {
            if(video == null){
                this.video = new VideoService(this.infoVideo);
            }

            System.out.println("\n=========== Videos ===========\n");
            video.carregamento();
            video.showVideo();
            System.out.printf("Exibindo video: %s ...", infoVideo);
            System.out.println("\n==============================;\n");
        }
    }
}

class Proxy {
    public static void main(String[] args) {
        Service proxy01 = new VideoProxy("video.mp4", true);
        Service proxy02 = new VideoProxy("e.mp4", false);
        
        proxy01.showVideo();
        proxy02.showVideo();
    }
}
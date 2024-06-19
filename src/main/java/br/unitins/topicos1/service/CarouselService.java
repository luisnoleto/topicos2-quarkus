package br.unitins.topicos1.service;

import java.io.File;
import java.util.List;

import br.unitins.topicos1.model.Slide;

public interface CarouselService {

    void salvar(Long id, String nomeImagemCarousel, byte[] imagem);

    File download(String nomeArquivo);

    List<Slide> getAllSlides();

    void removerPorJogoId(Long jogoId);

}
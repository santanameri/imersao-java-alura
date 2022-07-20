import java.io.File;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    public void cria() throws Exception {
        // Aula 02 - Gerando Figurinhas para Whatsapp

        // Leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg"));

        // Cria uma nova imagem em memória com transparência e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();

        // Aumentar a altura da imagem para poder escrever abaixo dela:
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // Copiar a imagem original para nova imagem (Memória):
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // Configurar a fonte:
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 25);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // Escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 0, novaAltura - 100);

        // Escrever a imagem nova em um arquivo
        ImageIO.write(novaImagem, "png", new File("saída/figurinha.png"));
    }

    public static void main(String[] args) throws Exception {
        var geradora = new GeradoraDeFigurinhas();
        geradora.cria();
    }

}

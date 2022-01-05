/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proxy;
/*


Proxy es un patrón de diseño estructural que proporciona un objeto que 
actúa como sustituto de un objeto de servicio real utilizado por un cliente. 
Un proxy recibe solicitudes del cliente, realiza parte del trabajo 
(control de acceso, almacenamiento en caché, etc.) y después pasa la solicitud a un objeto de servicio.

El objeto proxy tiene la misma interfaz que un servicio, lo que lo hace intercambiable 
con un objeto real cuando se pasa a un cliente.

Uso del patrón en Java

Ejemplos de uso: Aunque el patrón Proxy no es un invitado habitual en la mayoría de aplicaciones Java, 
resulta de mucha utilidad en algunos casos especiales. 
Es insustituible cuando queremos añadir algunos comportamientos adicionales 
a un objeto de una clase existente sin cambiar el código cliente.

Algunos ejemplos de proxies en bibliotecas Java estándar:

    java.lang.reflect.Proxy
    java.rmi.*
    javax.ejb.EJB (véanse los comentarios)
    javax.inject.Inject (véanse los comentarios)
    javax.persistence.PersistenceContext

Identificación: Los proxies delegan todo el trabajo real a otro objeto. 
Cada método proxy debe, al final, referirse a un objeto de servicio, 
a no ser que el proxy sea una subclase de un servicio.

*/

/**
 *
 * @author mrnov
 */
public class Demo {

    public static void main(String[] args) {
        YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeClass());
        YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");

    }

    private static long test(YouTubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        // User behavior in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        // Users might visit the same page quite often.
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}

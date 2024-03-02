package online.koymattprogrammer.MusicAPI.UseCases.interfaces;

public interface UseCase<IN, OUT> {

    OUT execute(IN value);

}

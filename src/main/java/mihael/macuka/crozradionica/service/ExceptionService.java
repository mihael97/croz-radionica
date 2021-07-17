package mihael.macuka.crozradionica.service;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class ExceptionService {
    public void getNullPointerException() {
        throw new NullPointerException();
    }

    public void getFileNotFoundException() throws FileNotFoundException {
        throw new FileNotFoundException();
    }
}

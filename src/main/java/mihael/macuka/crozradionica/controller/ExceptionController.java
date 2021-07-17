package mihael.macuka.crozradionica.controller;

import mihael.macuka.crozradionica.service.ExceptionService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exceptions")
public class ExceptionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);
    private final ExceptionService exceptionService;

    public ExceptionController(ExceptionService exceptionService) {
        this.exceptionService = exceptionService;
    }

    private static String exceptionToString(final Exception e) {
        return ExceptionUtils.getStackTrace(e);
    }

    @GetMapping("/{index}")
    public ResponseEntity<?> getNullPointerException(@PathVariable final Long index) {
        try {
            if (index == 1) {
                exceptionService.getNullPointerException();
            } else {
                exceptionService.getFileNotFoundException();
            }
        } catch (final Exception e) {
            LOGGER.error("Error: ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionToString(e));
        }
        return ResponseEntity.ok().build();
    }
}

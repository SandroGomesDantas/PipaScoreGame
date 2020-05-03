package br.com.pipa.score.service.utils;

import org.springframework.web.util.UriComponentsBuilder;
import springfox.documentation.spring.web.paths.AbstractPathProvider;
import springfox.documentation.spring.web.paths.Paths;

import javax.servlet.ServletContext;

public class PathUtil extends AbstractPathProvider {

    private String contextPath;
    private String basePath;

    public PathUtil(ServletContext servletContext, String basePath) {
        this.contextPath = (servletContext.getContextPath() == null || "".equals(servletContext.getContextPath())) ? "/"
                : servletContext.getContextPath();

        this.basePath = basePath;
    }

    @Override
    protected String applicationPath() {
        return this.contextPath + "/" + this.basePath;
    }

    @Override
    protected String getDocumentationPath() {
        return "/";
    }

    @Override
    public String getOperationPath(String operationPath) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("/");

        return Paths.removeAdjacentForwardSlashes(
                uriComponentsBuilder.path(operationPath.replaceFirst(this.basePath, "")).build().toString());
    }
}
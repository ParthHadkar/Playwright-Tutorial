package org.luv2code.framework.extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class LoggingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback,
        TestWatcher {
    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        System.out.println("[LOG] Test Finished -> "+extensionContext.getDisplayName());
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        System.out.println("[LOG] Test Started -> "+extensionContext.getDisplayName());
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("[LOG] Test Successful -> "+context.getDisplayName());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("[LOG] Test Failed -> "+context.getDisplayName());
    }
}

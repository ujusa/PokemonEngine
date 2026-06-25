import 'zone.js/testing';
import { getTestBed } from '@angular/core/testing';
import {
  BrowserDynamicTestingModule,
  platformBrowserDynamicTesting
} from '@angular/platform-browser-dynamic/testing';

declare const require: any;

getTestBed().initTestEnvironment(
  BrowserDynamicTestingModule,
  platformBrowserDynamicTesting()
);

// Fallback: use Karma's file list to load all .spec.ts files. This works regardless of require.context availability.
const allSpecFiles = Object.keys((window as any).__karma__.files)
  .filter((file: string) => /\.spec\.ts$/.test(file))
  .map((file: string) => file.replace(/^\/base\//, './'));

allSpecFiles.forEach((moduleId: string) => {
  // eslint-disable-next-line @typescript-eslint/no-var-requires
  require(moduleId);
});

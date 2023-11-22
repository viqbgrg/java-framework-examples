package com.github.viqbgrg.demo.easyexcel

import spock.lang.Specification

class ExportExcelTest extends Specification {
    def "SampleExport"() {
        def export = new ExportExcel()
        expect:
        export.sampleExport()
    }
}

/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */
package org.llvm.analysis.impl;

import org.llvm.cl.aliases.optBool;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.OptionHidden;
import org.llvm.cl.desc;


//<editor-fold defaultstate="collapsed" desc="static type RegionPrinterStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.RegionPrinterStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZL14viewRegionInfoPN4llvm10RegionInfoEb;_ZL17onlySimpleRegions;_ZL18invokeFunctionPassPKN4llvm8FunctionEPNS_12FunctionPassE;_ZL30InitializeRegionViewerPassFlag;_ZL30initializeRegionViewerPassOnceRN4llvm12PassRegistryE;_ZL31InitializeRegionPrinterPassFlag;_ZL31initializeRegionPrinterPassOnceRN4llvm12PassRegistryE;_ZL34InitializeRegionOnlyViewerPassFlag;_ZL34initializeRegionOnlyViewerPassOnceRN4llvm12PassRegistryE;_ZL35InitializeRegionOnlyPrinterPassFlag;_ZL35initializeRegionOnlyPrinterPassOnceRN4llvm12PassRegistryE; -static-type=RegionPrinterStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class RegionPrinterStatics {


//===----------------------------------------------------------------------===//
/// onlySimpleRegion - Show only the simple regions in the RegionViewer.
//<editor-fold defaultstate="collapsed" desc="onlySimpleRegions">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 31,
 FQN="onlySimpleRegions", NM="_ZL17onlySimpleRegions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZL17onlySimpleRegions")
//</editor-fold>
public static optBool onlySimpleRegions/*J*/= new optBool($("only-simple-regions"), 
    new desc($("Show only simple regions in the graphviz viewer")), 
    OptionHidden.Hidden, 
    init(false));
//end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="initializeRegionPrinterPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 201,
 FQN="initializeRegionPrinterPassOnce", NM="_ZL31initializeRegionPrinterPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZL31initializeRegionPrinterPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeRegionPrinterPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeRegionPrinterPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 201,
 FQN="InitializeRegionPrinterPassFlag", NM="_ZL31InitializeRegionPrinterPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZL31InitializeRegionPrinterPassFlag")
//</editor-fold>
public static std.once_flag InitializeRegionPrinterPassFlag/*J*/= new std.once_flag();
//<editor-fold defaultstate="collapsed" desc="initializeRegionOnlyPrinterPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 204,
 FQN="initializeRegionOnlyPrinterPassOnce", NM="_ZL35initializeRegionOnlyPrinterPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZL35initializeRegionOnlyPrinterPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeRegionOnlyPrinterPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeRegionOnlyPrinterPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 204,
 FQN="InitializeRegionOnlyPrinterPassFlag", NM="_ZL35InitializeRegionOnlyPrinterPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZL35InitializeRegionOnlyPrinterPassFlag")
//</editor-fold>
public static std.once_flag InitializeRegionOnlyPrinterPassFlag/*J*/= new std.once_flag();
//<editor-fold defaultstate="collapsed" desc="initializeRegionViewerPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 209,
 FQN="initializeRegionViewerPassOnce", NM="_ZL30initializeRegionViewerPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZL30initializeRegionViewerPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeRegionViewerPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeRegionViewerPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 209,
 FQN="InitializeRegionViewerPassFlag", NM="_ZL30InitializeRegionViewerPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZL30InitializeRegionViewerPassFlag")
//</editor-fold>
public static std.once_flag InitializeRegionViewerPassFlag/*J*/= new std.once_flag();
//<editor-fold defaultstate="collapsed" desc="initializeRegionOnlyViewerPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 212,
 FQN="initializeRegionOnlyViewerPassOnce", NM="_ZL34initializeRegionOnlyViewerPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZL34initializeRegionOnlyViewerPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeRegionOnlyViewerPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeRegionOnlyViewerPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 212,
 FQN="InitializeRegionOnlyViewerPassFlag", NM="_ZL34InitializeRegionOnlyViewerPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZL34InitializeRegionOnlyViewerPassFlag")
//</editor-fold>
public static std.once_flag InitializeRegionOnlyViewerPassFlag/*J*/= new std.once_flag();
//<editor-fold defaultstate="collapsed" desc="viewRegionInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 231,
 FQN="viewRegionInfo", NM="_ZL14viewRegionInfoPN4llvm10RegionInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZL14viewRegionInfoPN4llvm10RegionInfoEb")
//</editor-fold>
public static void viewRegionInfo(RegionInfo /*P*/ RI, boolean ShortNames) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="invokeFunctionPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 241,
 FQN="invokeFunctionPass", NM="_ZL18invokeFunctionPassPKN4llvm8FunctionEPNS_12FunctionPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZL18invokeFunctionPassPKN4llvm8FunctionEPNS_12FunctionPassE")
//</editor-fold>
public static void invokeFunctionPass(/*const*/ Function /*P*/ F, FunctionPass /*P*/ ViewerPass) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class RegionPrinterStatics

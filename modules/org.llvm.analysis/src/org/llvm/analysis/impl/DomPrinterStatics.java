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


//<editor-fold defaultstate="collapsed" desc="static type DomPrinterStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.DomPrinterStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZL27InitializeDomViewerPassFlag;_ZL27initializeDomViewerPassOnceRN4llvm12PassRegistryE;_ZL28InitializeDomPrinterPassFlag;_ZL28initializeDomPrinterPassOnceRN4llvm12PassRegistryE;_ZL31InitializeDomOnlyViewerPassFlag;_ZL31InitializePostDomViewerPassFlag;_ZL31initializeDomOnlyViewerPassOnceRN4llvm12PassRegistryE;_ZL31initializePostDomViewerPassOnceRN4llvm12PassRegistryE;_ZL32InitializeDomOnlyPrinterPassFlag;_ZL32InitializePostDomPrinterPassFlag;_ZL32initializeDomOnlyPrinterPassOnceRN4llvm12PassRegistryE;_ZL32initializePostDomPrinterPassOnceRN4llvm12PassRegistryE;_ZL35InitializePostDomOnlyViewerPassFlag;_ZL35initializePostDomOnlyViewerPassOnceRN4llvm12PassRegistryE;_ZL36InitializePostDomOnlyPrinterPassFlag;_ZL36initializePostDomOnlyPrinterPassOnceRN4llvm12PassRegistryE; -static-type=DomPrinterStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class DomPrinterStatics {

//<editor-fold defaultstate="collapsed" desc="initializeDomViewerPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 150,
 FQN="initializeDomViewerPassOnce", NM="_ZL27initializeDomViewerPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZL27initializeDomViewerPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeDomViewerPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeDomViewerPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 150,
 FQN="InitializeDomViewerPassFlag", NM="_ZL27InitializeDomViewerPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZL27InitializeDomViewerPassFlag")
//</editor-fold>
public static std.once_flag InitializeDomViewerPassFlag/*J*/= new std.once_flag();
//<editor-fold defaultstate="collapsed" desc="initializeDomOnlyViewerPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 154,
 FQN="initializeDomOnlyViewerPassOnce", NM="_ZL31initializeDomOnlyViewerPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZL31initializeDomOnlyViewerPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeDomOnlyViewerPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeDomOnlyViewerPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 154,
 FQN="InitializeDomOnlyViewerPassFlag", NM="_ZL31InitializeDomOnlyViewerPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZL31InitializeDomOnlyViewerPassFlag")
//</editor-fold>
public static std.once_flag InitializeDomOnlyViewerPassFlag/*J*/= new std.once_flag();
//<editor-fold defaultstate="collapsed" desc="initializePostDomViewerPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 159,
 FQN="initializePostDomViewerPassOnce", NM="_ZL31initializePostDomViewerPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZL31initializePostDomViewerPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializePostDomViewerPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializePostDomViewerPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 159,
 FQN="InitializePostDomViewerPassFlag", NM="_ZL31InitializePostDomViewerPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZL31InitializePostDomViewerPassFlag")
//</editor-fold>
public static std.once_flag InitializePostDomViewerPassFlag/*J*/= new std.once_flag();
//<editor-fold defaultstate="collapsed" desc="initializePostDomOnlyViewerPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 163,
 FQN="initializePostDomOnlyViewerPassOnce", NM="_ZL35initializePostDomOnlyViewerPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZL35initializePostDomOnlyViewerPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializePostDomOnlyViewerPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializePostDomOnlyViewerPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 163,
 FQN="InitializePostDomOnlyViewerPassFlag", NM="_ZL35InitializePostDomOnlyViewerPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZL35InitializePostDomOnlyViewerPassFlag")
//</editor-fold>
public static std.once_flag InitializePostDomOnlyViewerPassFlag/*J*/= new std.once_flag();
//<editor-fold defaultstate="collapsed" desc="initializeDomPrinterPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 227,
 FQN="initializeDomPrinterPassOnce", NM="_ZL28initializeDomPrinterPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZL28initializeDomPrinterPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeDomPrinterPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeDomPrinterPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 227,
 FQN="InitializeDomPrinterPassFlag", NM="_ZL28InitializeDomPrinterPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZL28InitializeDomPrinterPassFlag")
//</editor-fold>
public static std.once_flag InitializeDomPrinterPassFlag/*J*/= new std.once_flag();
//<editor-fold defaultstate="collapsed" desc="initializeDomOnlyPrinterPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 232,
 FQN="initializeDomOnlyPrinterPassOnce", NM="_ZL32initializeDomOnlyPrinterPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZL32initializeDomOnlyPrinterPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeDomOnlyPrinterPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeDomOnlyPrinterPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 232,
 FQN="InitializeDomOnlyPrinterPassFlag", NM="_ZL32InitializeDomOnlyPrinterPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZL32InitializeDomOnlyPrinterPassFlag")
//</editor-fold>
public static std.once_flag InitializeDomOnlyPrinterPassFlag/*J*/= new std.once_flag();
//<editor-fold defaultstate="collapsed" desc="initializePostDomPrinterPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 238,
 FQN="initializePostDomPrinterPassOnce", NM="_ZL32initializePostDomPrinterPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZL32initializePostDomPrinterPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializePostDomPrinterPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializePostDomPrinterPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 238,
 FQN="InitializePostDomPrinterPassFlag", NM="_ZL32InitializePostDomPrinterPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZL32InitializePostDomPrinterPassFlag")
//</editor-fold>
public static std.once_flag InitializePostDomPrinterPassFlag/*J*/= new std.once_flag();
//<editor-fold defaultstate="collapsed" desc="initializePostDomOnlyPrinterPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 243,
 FQN="initializePostDomOnlyPrinterPassOnce", NM="_ZL36initializePostDomOnlyPrinterPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZL36initializePostDomOnlyPrinterPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializePostDomOnlyPrinterPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializePostDomOnlyPrinterPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 243,
 FQN="InitializePostDomOnlyPrinterPassFlag", NM="_ZL36InitializePostDomOnlyPrinterPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZL36InitializePostDomOnlyPrinterPassFlag")
//</editor-fold>
public static std.once_flag InitializePostDomOnlyPrinterPassFlag/*J*/= new std.once_flag();
} // END OF class DomPrinterStatics

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

package org.llvm.ir;

import org.clank.support.*;
import org.llvm.ir.*;


/// Diagnostic information for stripping invalid debug metadata.
//<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoIgnoringInvalidDebugMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 254,
 FQN="llvm::DiagnosticInfoIgnoringInvalidDebugMetadata", NM="_ZN4llvm42DiagnosticInfoIgnoringInvalidDebugMetadataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm42DiagnosticInfoIgnoringInvalidDebugMetadataE")
//</editor-fold>
public class DiagnosticInfoIgnoringInvalidDebugMetadata extends /*public*/ DiagnosticInfo implements Destructors.ClassWithDestructor {
/*private:*/
  /// The module that is concerned by this debug metadata version diagnostic.
  private final /*const*/ Module /*&*/ M;
/*public:*/
  /// \p The module that is concerned by this debug metadata version diagnostic.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoIgnoringInvalidDebugMetadata::DiagnosticInfoIgnoringInvalidDebugMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 261,
   FQN="llvm::DiagnosticInfoIgnoringInvalidDebugMetadata::DiagnosticInfoIgnoringInvalidDebugMetadata", NM="_ZN4llvm42DiagnosticInfoIgnoringInvalidDebugMetadataC1ERKNS_6ModuleENS_18DiagnosticSeverityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm42DiagnosticInfoIgnoringInvalidDebugMetadataC1ERKNS_6ModuleENS_18DiagnosticSeverityE")
  //</editor-fold>
  public DiagnosticInfoIgnoringInvalidDebugMetadata(final /*const*/ Module /*&*/ M) {
    this(M, DiagnosticSeverity.DS_Warning);
  }
  public DiagnosticInfoIgnoringInvalidDebugMetadata(final /*const*/ Module /*&*/ M, DiagnosticSeverity Severity/*= DS_Warning*/) {
    // : DiagnosticInfo(DK_DebugMetadataVersion, Severity), M(M)
    //START JInit
    super(DiagnosticKind.DK_DebugMetadataVersion.getValue(), Severity);
    this./*&*/M=/*&*/M;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoIgnoringInvalidDebugMetadata::getModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 265,
   FQN="llvm::DiagnosticInfoIgnoringInvalidDebugMetadata::getModule", NM="_ZNK4llvm42DiagnosticInfoIgnoringInvalidDebugMetadata9getModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm42DiagnosticInfoIgnoringInvalidDebugMetadata9getModuleEv")
  //</editor-fold>
  public /*const*/ Module /*&*/ getModule() /*const*/ {
    return M;
  }


  /// \see DiagnosticInfo::print.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoIgnoringInvalidDebugMetadata::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 129,
   FQN="llvm::DiagnosticInfoIgnoringInvalidDebugMetadata::print", NM="_ZNK4llvm42DiagnosticInfoIgnoringInvalidDebugMetadata5printERNS_17DiagnosticPrinterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm42DiagnosticInfoIgnoringInvalidDebugMetadata5printERNS_17DiagnosticPrinterE")
  //</editor-fold>
  @Override public void print(final DiagnosticPrinter /*&*/ DP) /*const*//* override*/ {
    DP.$out(/*KEEP_STR*/"ignoring invalid debug info in ").$out(getModule().getModuleIdentifier());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoIgnoringInvalidDebugMetadata::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 270,
   FQN="llvm::DiagnosticInfoIgnoringInvalidDebugMetadata::classof", NM="_ZN4llvm42DiagnosticInfoIgnoringInvalidDebugMetadata7classofEPKNS_14DiagnosticInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm42DiagnosticInfoIgnoringInvalidDebugMetadata7classofEPKNS_14DiagnosticInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ DiagnosticInfo /*P*/ DI) {
    return DI.getKind() == DiagnosticKind.DK_DebugMetadataInvalid.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoIgnoringInvalidDebugMetadata::~DiagnosticInfoIgnoringInvalidDebugMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 254,
   FQN="llvm::DiagnosticInfoIgnoringInvalidDebugMetadata::~DiagnosticInfoIgnoringInvalidDebugMetadata", NM="_ZN4llvm42DiagnosticInfoIgnoringInvalidDebugMetadataD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm42DiagnosticInfoIgnoringInvalidDebugMetadataD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + "M=" + M // NOI18N
              + super.toString(); // NOI18N
  }
}

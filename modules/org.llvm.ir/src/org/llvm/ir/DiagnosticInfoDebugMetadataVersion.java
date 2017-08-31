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


/// Diagnostic information for debug metadata version reporting.
/// This is basically a module and a version.
//<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoDebugMetadataVersion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 227,
 FQN="llvm::DiagnosticInfoDebugMetadataVersion", NM="_ZN4llvm34DiagnosticInfoDebugMetadataVersionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm34DiagnosticInfoDebugMetadataVersionE")
//</editor-fold>
public class DiagnosticInfoDebugMetadataVersion extends /*public*/ DiagnosticInfo implements Destructors.ClassWithDestructor {
/*private:*/
  /// The module that is concerned by this debug metadata version diagnostic.
  private final /*const*/ Module /*&*/ M;
  /// The actual metadata version.
  private /*uint*/int MetadataVersion;
/*public:*/
  /// \p The module that is concerned by this debug metadata version diagnostic.
  /// \p The actual metadata version.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoDebugMetadataVersion::DiagnosticInfoDebugMetadataVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 237,
   FQN="llvm::DiagnosticInfoDebugMetadataVersion::DiagnosticInfoDebugMetadataVersion", NM="_ZN4llvm34DiagnosticInfoDebugMetadataVersionC1ERKNS_6ModuleEjNS_18DiagnosticSeverityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm34DiagnosticInfoDebugMetadataVersionC1ERKNS_6ModuleEjNS_18DiagnosticSeverityE")
  //</editor-fold>
  public DiagnosticInfoDebugMetadataVersion(final /*const*/ Module /*&*/ M, /*uint*/int MetadataVersion) {
    this(M, MetadataVersion,
      DiagnosticSeverity.DS_Warning);
  }
  public DiagnosticInfoDebugMetadataVersion(final /*const*/ Module /*&*/ M, /*uint*/int MetadataVersion,
      DiagnosticSeverity Severity/*= DS_Warning*/) {
    // : DiagnosticInfo(DK_DebugMetadataVersion, Severity), M(M), MetadataVersion(MetadataVersion)
    //START JInit
    super(DiagnosticKind.DK_DebugMetadataVersion.getValue(), Severity);
    this./*&*/M=/*&*/M;
    this.MetadataVersion = MetadataVersion;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoDebugMetadataVersion::getModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 242,
   FQN="llvm::DiagnosticInfoDebugMetadataVersion::getModule", NM="_ZNK4llvm34DiagnosticInfoDebugMetadataVersion9getModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm34DiagnosticInfoDebugMetadataVersion9getModuleEv")
  //</editor-fold>
  public /*const*/ Module /*&*/ getModule() /*const*/ {
    return M;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoDebugMetadataVersion::getMetadataVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 243,
   FQN="llvm::DiagnosticInfoDebugMetadataVersion::getMetadataVersion", NM="_ZNK4llvm34DiagnosticInfoDebugMetadataVersion18getMetadataVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm34DiagnosticInfoDebugMetadataVersion18getMetadataVersionEv")
  //</editor-fold>
  public /*uint*/int getMetadataVersion() /*const*/ {
    return MetadataVersion;
  }


  /// \see DiagnosticInfo::print.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoDebugMetadataVersion::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 124,
   FQN="llvm::DiagnosticInfoDebugMetadataVersion::print", NM="_ZNK4llvm34DiagnosticInfoDebugMetadataVersion5printERNS_17DiagnosticPrinterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm34DiagnosticInfoDebugMetadataVersion5printERNS_17DiagnosticPrinterE")
  //</editor-fold>
  @Override public void print(final DiagnosticPrinter /*&*/ DP) /*const*//* override*/ {
    DP.$out(/*KEEP_STR*/"ignoring debug info with an invalid version (").$out_uint(getMetadataVersion()).$out(
        /*KEEP_STR*/") in "
    ).$out(getModule());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoDebugMetadataVersion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 248,
   FQN="llvm::DiagnosticInfoDebugMetadataVersion::classof", NM="_ZN4llvm34DiagnosticInfoDebugMetadataVersion7classofEPKNS_14DiagnosticInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm34DiagnosticInfoDebugMetadataVersion7classofEPKNS_14DiagnosticInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ DiagnosticInfo /*P*/ DI) {
    return DI.getKind() == DiagnosticKind.DK_DebugMetadataVersion.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoDebugMetadataVersion::~DiagnosticInfoDebugMetadataVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 227,
   FQN="llvm::DiagnosticInfoDebugMetadataVersion::~DiagnosticInfoDebugMetadataVersion", NM="_ZN4llvm34DiagnosticInfoDebugMetadataVersionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm34DiagnosticInfoDebugMetadataVersionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + "M=" + M // NOI18N
              + ", MetadataVersion=" + MetadataVersion // NOI18N
              + super.toString(); // NOI18N
  }
}

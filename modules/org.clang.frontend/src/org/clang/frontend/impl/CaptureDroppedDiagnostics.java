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

package org.clang.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.frontend.impl.*;


/// \brief RAII object that optionally captures diagnostics, if
/// there is no diagnostic client to capture them already.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CaptureDroppedDiagnostics">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 583,
 FQN="(anonymous namespace)::CaptureDroppedDiagnostics", NM="_ZN12_GLOBAL__N_125CaptureDroppedDiagnosticsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_125CaptureDroppedDiagnosticsE")
//</editor-fold>
public class CaptureDroppedDiagnostics implements Destructors.ClassWithDestructor {
  private DiagnosticsEngine /*&*/ Diags;
  private StoredDiagnosticConsumer Client;
  private DiagnosticConsumer /*P*/ PreviousClient;
  private std.unique_ptr<DiagnosticConsumer> OwningPreviousClient;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CaptureDroppedDiagnostics::CaptureDroppedDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 590,
   FQN="(anonymous namespace)::CaptureDroppedDiagnostics::CaptureDroppedDiagnostics", NM="_ZN12_GLOBAL__N_125CaptureDroppedDiagnosticsC1EbRN5clang17DiagnosticsEngineERN4llvm15SmallVectorImplINS1_16StoredDiagnosticEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_125CaptureDroppedDiagnosticsC1EbRN5clang17DiagnosticsEngineERN4llvm15SmallVectorImplINS1_16StoredDiagnosticEEE")
  //</editor-fold>
  public CaptureDroppedDiagnostics(boolean RequestCapture, DiagnosticsEngine /*&*/ Diags, 
      SmallVectorImpl<StoredDiagnostic> /*&*/ StoredDiags) {
    // : Diags(Diags), Client(StoredDiags), PreviousClient(null), OwningPreviousClient() 
    //START JInit
    this./*&*/Diags=/*&*/Diags;
    this.Client = new StoredDiagnosticConsumer(StoredDiags);
    this.PreviousClient = null;
    this.OwningPreviousClient = new std.unique_ptr<DiagnosticConsumer>();
    //END JInit
    if (RequestCapture || Diags.getClient() == null) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(OwningPreviousClient.$assignMove($c$.track(Diags.takeClient())));
        PreviousClient = Diags.getClient();
        Diags.setClient(/*AddrOf*/Client, false);
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CaptureDroppedDiagnostics::~CaptureDroppedDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 601,
   FQN="(anonymous namespace)::CaptureDroppedDiagnostics::~CaptureDroppedDiagnostics", NM="_ZN12_GLOBAL__N_125CaptureDroppedDiagnosticsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_125CaptureDroppedDiagnosticsD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (Diags.getClient() == /*AddrOf*/Client) {
      Diags.setClient(PreviousClient, !!(OwningPreviousClient.release() != null));
    }
    //START JDestroy
    OwningPreviousClient.$destroy();
    Client.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" /* STACKOVERFLOW: NEVER PRINT DIAGS + ", Diags=" + Diags // NOI18N*/
              + ", Client=" + Client // NOI18N
              + ", PreviousClient=" + PreviousClient // NOI18N
              + ", OwningPreviousClient=" + OwningPreviousClient; // NOI18N
  }
}

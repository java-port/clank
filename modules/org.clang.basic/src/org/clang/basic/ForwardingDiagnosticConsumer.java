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

package org.clang.basic;

import org.clank.support.*;
import org.clang.basic.*;


/// \brief Diagnostic consumer that forwards diagnostics along to an
/// existing, already-initialized diagnostic consumer.
///
//<editor-fold defaultstate="collapsed" desc="clang::ForwardingDiagnosticConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1381,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1374,
 FQN="clang::ForwardingDiagnosticConsumer", NM="_ZN5clang28ForwardingDiagnosticConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang28ForwardingDiagnosticConsumerE")
//</editor-fold>
public class ForwardingDiagnosticConsumer extends /*public*/ DiagnosticConsumer implements Destructors.ClassWithDestructor {
  private DiagnosticConsumer /*&*/ Target;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ForwardingDiagnosticConsumer::ForwardingDiagnosticConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1385,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1378,
   FQN="clang::ForwardingDiagnosticConsumer::ForwardingDiagnosticConsumer", NM="_ZN5clang28ForwardingDiagnosticConsumerC1ERNS_18DiagnosticConsumerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang28ForwardingDiagnosticConsumerC1ERNS_18DiagnosticConsumerE")
  //</editor-fold>
  public ForwardingDiagnosticConsumer(DiagnosticConsumer /*&*/ Target) {
    /* : DiagnosticConsumer(), Target(Target)*/ 
    //START JInit
    super();
    this.Target = Target;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForwardingDiagnosticConsumer::~ForwardingDiagnosticConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 985,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 984,
   FQN="clang::ForwardingDiagnosticConsumer::~ForwardingDiagnosticConsumer", NM="_ZN5clang28ForwardingDiagnosticConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang28ForwardingDiagnosticConsumerD0Ev")
  //</editor-fold>
  @Override public void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForwardingDiagnosticConsumer::HandleDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 987,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 986,
   FQN="clang::ForwardingDiagnosticConsumer::HandleDiagnostic", NM="_ZN5clang28ForwardingDiagnosticConsumer16HandleDiagnosticENS_17DiagnosticsEngine5LevelERKNS_10DiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang28ForwardingDiagnosticConsumer16HandleDiagnosticENS_17DiagnosticsEngine5LevelERKNS_10DiagnosticE")
  //</editor-fold>
  @Override public void HandleDiagnostic(DiagnosticsEngine.Level DiagLevel, /*const*/Diagnostic /*&*/ Info) {
    Target.HandleDiagnostic(DiagLevel, Info);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForwardingDiagnosticConsumer::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 993,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 992,
   FQN="clang::ForwardingDiagnosticConsumer::clear", NM="_ZN5clang28ForwardingDiagnosticConsumer5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang28ForwardingDiagnosticConsumer5clearEv")
  //</editor-fold>
  @Override public void clear() {
    super.clear();
    Target.clear();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForwardingDiagnosticConsumer::IncludeInDiagnosticCounts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 998,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 997,
   FQN="clang::ForwardingDiagnosticConsumer::IncludeInDiagnosticCounts", NM="_ZNK5clang28ForwardingDiagnosticConsumer25IncludeInDiagnosticCountsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang28ForwardingDiagnosticConsumer25IncludeInDiagnosticCountsEv")
  //</editor-fold>
  @Override public boolean IncludeInDiagnosticCounts() /*const*/ {
    return Target.IncludeInDiagnosticCounts();
  }

}

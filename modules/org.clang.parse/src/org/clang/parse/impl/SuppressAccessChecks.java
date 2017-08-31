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

package org.clang.parse.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import org.clang.sema.*;
import org.clang.parse.*;

// TODO: move ParsingClassDefinition here.
// TODO: move TentativeParsingAction here.

/// \brief A RAII object used to temporarily suppress access-like
/// checking.  Access-like checks are those associated with
/// controlling the use of a declaration, like C++ access control
/// errors and deprecation warnings.  They are contextually
/// dependent, in that they can only be resolved with full
/// information about what's being declared.  They are also
/// suppressed in certain contexts, like the template arguments of
/// an explicit instantiation.  However, those suppression contexts
/// cannot necessarily be fully determined in advance;  for
/// example, something starting like this:
///   template <> class std::vector<A::PrivateType>
/// might be the entirety of an explicit instantiation:
///   template <> class std::vector<A::PrivateType>;
/// or just an elaborated type specifier:
///   template <> class std::vector<A::PrivateType> make_vector<>();
/// Therefore this class collects all the diagnostics and permits
/// them to be re-delayed in a new context.
//<editor-fold defaultstate="collapsed" desc="clang::SuppressAccessChecks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 44,
 FQN="clang::SuppressAccessChecks", NM="_ZN5clang20SuppressAccessChecksE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang20SuppressAccessChecksE")
//</editor-fold>
public class SuppressAccessChecks implements Destructors.ClassWithDestructor, NativeCloneable<SuppressAccessChecks>, NativeMoveable<SuppressAccessChecks> {
  private final Sema /*&*/ S;
  private DelayedDiagnosticPool DiagnosticPool;
  private Sema.DelayedDiagnosticsState State;
  private boolean Active;
/*public:*/
  /// Begin suppressing access-like checks 
  //<editor-fold defaultstate="collapsed" desc="clang::SuppressAccessChecks::SuppressAccessChecks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 52,
   FQN="clang::SuppressAccessChecks::SuppressAccessChecks", NM="_ZN5clang20SuppressAccessChecksC1ERNS_6ParserEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang20SuppressAccessChecksC1ERNS_6ParserEb")
  //</editor-fold>
  public SuppressAccessChecks(Parser /*&*/ P) {
    this(P, true);
  }
  public SuppressAccessChecks(Parser /*&*/ P, boolean activate/*= true*/) {
    // : S(P.getActions()), DiagnosticPool(null), State() 
    //START JInit
    this./*&*/S=/*&*/P.getActions();
    this.DiagnosticPool = new DelayedDiagnosticPool(JD$DelayedDiagnosticPool$C$P.INSTANCE, (/*const*/ DelayedDiagnosticPool /*P*/ )null);
    this.State = new Sema.DelayedDiagnosticsState();
    //END JInit
    if (activate) {
      State.$assignMove(S.PushParsingDeclaration(DiagnosticPool));
      Active = true;
    } else {
      Active = false;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SuppressAccessChecks::SuppressAccessChecks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 61,
   FQN="clang::SuppressAccessChecks::SuppressAccessChecks", NM="_ZN5clang20SuppressAccessChecksC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang20SuppressAccessChecksC1EOS0_")
  //</editor-fold>
  public SuppressAccessChecks(JD$Move _dparam, SuppressAccessChecks /*&&*/Other) {
    // : S(Other.S), DiagnosticPool(std::move(Other.DiagnosticPool)), State(Other.State), Active(Other.Active) 
    //START JInit
    this./*&*/S=/*&*/Other.S;
    this.DiagnosticPool = new DelayedDiagnosticPool(JD$Move.INSTANCE, std.move(Other.DiagnosticPool));
    this.State = new Sema.DelayedDiagnosticsState(Other.State);
    this.Active = Other.Active;
    //END JInit
    Other.Active = false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SuppressAccessChecks::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 66,
   FQN="clang::SuppressAccessChecks::operator=", NM="_ZN5clang20SuppressAccessChecksaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang20SuppressAccessChecksaSEOS0_")
  //</editor-fold>
  public void $assignMove(SuppressAccessChecks /*&&*/Other) { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="clang::SuppressAccessChecks::done">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 68,
   FQN="clang::SuppressAccessChecks::done", NM="_ZN5clang20SuppressAccessChecks4doneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang20SuppressAccessChecks4doneEv")
  //</editor-fold>
  public void done() {
    assert (Active) : "trying to end an inactive suppression";
    S.PopParsingDeclaration(new Sema.DelayedDiagnosticsState(State), (Decl /*P*/ )null);
    Active = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SuppressAccessChecks::redelay">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 74,
   FQN="clang::SuppressAccessChecks::redelay", NM="_ZN5clang20SuppressAccessChecks7redelayEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang20SuppressAccessChecks7redelayEv")
  //</editor-fold>
  public void redelay() {
    assert (!Active) : "redelaying without having ended first";
    if (!DiagnosticPool.pool_empty()) {
      S.redelayDiagnostics(DiagnosticPool);
    }
    assert (DiagnosticPool.pool_empty());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SuppressAccessChecks::~SuppressAccessChecks">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*handle dummy default-value objects destroy from assertDefaultValue*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 81,
   FQN="clang::SuppressAccessChecks::~SuppressAccessChecks", NM="_ZN5clang20SuppressAccessChecksD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang20SuppressAccessChecksD0Ev")
  //</editor-fold>
  public void $destroy() {
    // JAVA: default value handling:
    if (DiagnosticPool == null) {
      assert S == null;
      assert State == null;
      assert !Active;
      return;
    }
    if (Active) {
      done();
    }
    //START JDestroy
    DiagnosticPool.$destroy();
    //END JDestroy
  }

  public SuppressAccessChecks() {
    this.S = null;
    this.DiagnosticPool = null;
    this.State = null;
  }

  @Override public SuppressAccessChecks clone() {
    // can be used only by check-cloneable
    assert this.S == null;
    assert this.DiagnosticPool == null;
    assert this.State == null;
    return new SuppressAccessChecks();
  }
  
  @Override
  public SuppressAccessChecks move() {
    assert this.S != null;
    assert this.DiagnosticPool != null;
    assert this.State != null;
    return new SuppressAccessChecks(JD$Move.INSTANCE, this);
  }
  
  @Override public String toString() {
    return "" + "S=" + S // NOI18N
              + ", DiagnosticPool=" + DiagnosticPool // NOI18N
              + ", State=" + State // NOI18N
              + ", Active=" + Active; // NOI18N
  }
}

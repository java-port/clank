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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import org.clang.sema.*;
import org.clang.parse.*;
import org.clang.parse.impl.*;


/// \brief RAII object used to inform the actions that we're
/// currently parsing a declaration.  This is active when parsing a
/// variable's initializer, but not when parsing the body of a
/// class or function definition.
//<editor-fold defaultstate="collapsed" desc="clang::ParsingDeclRAIIObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 90,
 FQN="clang::ParsingDeclRAIIObject", NM="_ZN5clang21ParsingDeclRAIIObjectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21ParsingDeclRAIIObjectE")
//</editor-fold>
public class ParsingDeclRAIIObject implements Destructors.ClassWithDestructor {
  private Sema /*&*/ Actions;
  private DelayedDiagnosticPool DiagnosticPool;
  private Sema.DelayedDiagnosticsState State;
  private boolean Popped;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ParsingDeclRAIIObject::ParsingDeclRAIIObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 96,
   FQN="clang::ParsingDeclRAIIObject::ParsingDeclRAIIObject", NM="_ZN5clang21ParsingDeclRAIIObjectC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21ParsingDeclRAIIObjectC1ERKS0_")
  //</editor-fold>
  private ParsingDeclRAIIObject(/*const*/ ParsingDeclRAIIObject /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::ParsingDeclRAIIObject::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 97,
   FQN="clang::ParsingDeclRAIIObject::operator=", NM="_ZN5clang21ParsingDeclRAIIObjectaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21ParsingDeclRAIIObjectaSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ ParsingDeclRAIIObject /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ParsingDeclRAIIObject::NoParent_t">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 100,
   FQN="clang::ParsingDeclRAIIObject::NoParent_t", NM="_ZN5clang21ParsingDeclRAIIObject10NoParent_tE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21ParsingDeclRAIIObject10NoParent_tE")
  //</editor-fold>
  public enum NoParent_t implements Native.ComparableLower {
    NoParent(0);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static NoParent_t valueOf(int val) {
      NoParent_t out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NoParent_t[] VALUES;
      private static final NoParent_t[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NoParent_t kind : NoParent_t.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NoParent_t[min < 0 ? (1-min) : 0];
        VALUES = new NoParent_t[max >= 0 ? (1+max) : 0];
        for (NoParent_t kind : NoParent_t.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private NoParent_t(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((NoParent_t)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((NoParent_t)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="clang::ParsingDeclRAIIObject::ParsingDeclRAIIObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 101,
   FQN="clang::ParsingDeclRAIIObject::ParsingDeclRAIIObject", NM="_ZN5clang21ParsingDeclRAIIObjectC1ERNS_6ParserENS0_10NoParent_tE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21ParsingDeclRAIIObjectC1ERNS_6ParserENS0_10NoParent_tE")
  //</editor-fold>
  public ParsingDeclRAIIObject(Parser /*&*/ P, NoParent_t $Prm) {
    // : Actions(P.getActions()), DiagnosticPool(null), State() 
    //START JInit
    this./*&*/Actions=/*&*/P.getActions();
    this.DiagnosticPool = new DelayedDiagnosticPool(JD$DelayedDiagnosticPool$C$P.INSTANCE, (/*const*/ DelayedDiagnosticPool /*P*/ )null);
    this.State = new Sema.DelayedDiagnosticsState();
    //END JInit
    push();
  }

  
  /// Creates a RAII object whose pool is optionally parented by another.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsingDeclRAIIObject::ParsingDeclRAIIObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 107,
   FQN="clang::ParsingDeclRAIIObject::ParsingDeclRAIIObject", NM="_ZN5clang21ParsingDeclRAIIObjectC1ERNS_6ParserEPKNS_4sema21DelayedDiagnosticPoolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21ParsingDeclRAIIObjectC1ERNS_6ParserEPKNS_4sema21DelayedDiagnosticPoolE")
  //</editor-fold>
  public ParsingDeclRAIIObject(Parser /*&*/ P, 
      /*const*/ DelayedDiagnosticPool /*P*/ parentPool) {
    // : Actions(P.getActions()), DiagnosticPool(parentPool), State() 
    //START JInit
    this./*&*/Actions=/*&*/P.getActions();
    this.DiagnosticPool = new DelayedDiagnosticPool(JD$DelayedDiagnosticPool$C$P.INSTANCE, parentPool);
    this.State = new Sema.DelayedDiagnosticsState();
    //END JInit
    push();
  }

  
  /// Creates a RAII object and, optionally, initialize its
  /// diagnostics pool by stealing the diagnostics from another
  /// RAII object (which is assumed to be the current top pool).
  //<editor-fold defaultstate="collapsed" desc="clang::ParsingDeclRAIIObject::ParsingDeclRAIIObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 116,
   FQN="clang::ParsingDeclRAIIObject::ParsingDeclRAIIObject", NM="_ZN5clang21ParsingDeclRAIIObjectC1ERNS_6ParserEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21ParsingDeclRAIIObjectC1ERNS_6ParserEPS0_")
  //</editor-fold>
  public ParsingDeclRAIIObject(Parser /*&*/ P, ParsingDeclRAIIObject /*P*/ other) {
    // : Actions(P.getActions()), DiagnosticPool(other ? other->DiagnosticPool.getParent() : null), State() 
    //START JInit
    this./*&*/Actions=/*&*/P.getActions();
    this.DiagnosticPool = new DelayedDiagnosticPool(JD$DelayedDiagnosticPool$C$P.INSTANCE, (other != null) ? other.DiagnosticPool.getParent() : (/*const*/ DelayedDiagnosticPool /*P*/ )null);
    this.State = new Sema.DelayedDiagnosticsState();
    //END JInit
    if ((other != null)) {
      DiagnosticPool.steal(other.DiagnosticPool);
      other.abort();
    }
    push();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParsingDeclRAIIObject::~ParsingDeclRAIIObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 126,
   FQN="clang::ParsingDeclRAIIObject::~ParsingDeclRAIIObject", NM="_ZN5clang21ParsingDeclRAIIObjectD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21ParsingDeclRAIIObjectD0Ev")
  //</editor-fold>
  public void $destroy() {
    abort();
    //START JDestroy
    DiagnosticPool.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParsingDeclRAIIObject::getDelayedDiagnosticPool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 130,
   FQN="clang::ParsingDeclRAIIObject::getDelayedDiagnosticPool", NM="_ZN5clang21ParsingDeclRAIIObject24getDelayedDiagnosticPoolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21ParsingDeclRAIIObject24getDelayedDiagnosticPoolEv")
  //</editor-fold>
  public DelayedDiagnosticPool /*&*/ getDelayedDiagnosticPool() {
    return DiagnosticPool;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParsingDeclRAIIObject::getDelayedDiagnosticPool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 133,
   FQN="clang::ParsingDeclRAIIObject::getDelayedDiagnosticPool", NM="_ZNK5clang21ParsingDeclRAIIObject24getDelayedDiagnosticPoolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang21ParsingDeclRAIIObject24getDelayedDiagnosticPoolEv")
  //</editor-fold>
  public /*const*/ DelayedDiagnosticPool /*&*/ getDelayedDiagnosticPool$Const() /*const*/ {
    return DiagnosticPool;
  }

  
  /// Resets the RAII object for a new declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsingDeclRAIIObject::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 138,
   FQN="clang::ParsingDeclRAIIObject::reset", NM="_ZN5clang21ParsingDeclRAIIObject5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21ParsingDeclRAIIObject5resetEv")
  //</editor-fold>
  public void reset() {
    abort();
    push();
  }

  
  /// Signals that the context was completed without an appropriate
  /// declaration being parsed.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsingDeclRAIIObject::abort">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 145,
   FQN="clang::ParsingDeclRAIIObject::abort", NM="_ZN5clang21ParsingDeclRAIIObject5abortEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21ParsingDeclRAIIObject5abortEv")
  //</editor-fold>
  public void abort() {
    pop((Decl /*P*/ )null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParsingDeclRAIIObject::complete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 149,
   FQN="clang::ParsingDeclRAIIObject::complete", NM="_ZN5clang21ParsingDeclRAIIObject8completeEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21ParsingDeclRAIIObject8completeEPNS_4DeclE")
  //</editor-fold>
  public void complete(Decl /*P*/ D) {
    assert (!Popped) : "ParsingDeclaration has already been popped!";
    pop(D);
  }

  
  /// Unregister this object from Sema, but remember all the
  /// diagnostics that were emitted into it.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsingDeclRAIIObject::abortAndRemember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 156,
   FQN="clang::ParsingDeclRAIIObject::abortAndRemember", NM="_ZN5clang21ParsingDeclRAIIObject16abortAndRememberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21ParsingDeclRAIIObject16abortAndRememberEv")
  //</editor-fold>
  public void abortAndRemember() {
    pop((Decl /*P*/ )null);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ParsingDeclRAIIObject::push">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 161,
   FQN="clang::ParsingDeclRAIIObject::push", NM="_ZN5clang21ParsingDeclRAIIObject4pushEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21ParsingDeclRAIIObject4pushEv")
  //</editor-fold>
  private void push() {
    State.$assignMove(Actions.PushParsingDeclaration(DiagnosticPool));
    Popped = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParsingDeclRAIIObject::pop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 166,
   FQN="clang::ParsingDeclRAIIObject::pop", NM="_ZN5clang21ParsingDeclRAIIObject3popEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21ParsingDeclRAIIObject3popEPNS_4DeclE")
  //</editor-fold>
  private void pop(Decl /*P*/ D) {
    if (!Popped) {
      Actions.PopParsingDeclaration(new Sema.DelayedDiagnosticsState(State), D);
      Popped = true;
    }
  }

  
  @Override public String toString() {
    return "" + "Actions=" + Actions // NOI18N
              + ", DiagnosticPool=" + DiagnosticPool // NOI18N
              + ", State=" + State // NOI18N
              + ", Popped=" + Popped; // NOI18N
  }
}

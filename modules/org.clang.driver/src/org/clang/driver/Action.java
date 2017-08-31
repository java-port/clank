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

package org.clang.driver;

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.JD$T$C$P_T2$C$R;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
;


/// Action - Represent an abstract compilation step to perform.
///
/// An action represents an edge in the compilation graph; typically
/// it is a job to transform an input using some tool.
///
/// The current driver is hard wired to expect actions which produce a
/// single primary output, at least in terms of controlling the
/// compilation. Actions can produce auxiliary files, but can only
/// produce a single output to feed into subsequent actions.
///
/// Actions are usually owned by a Compilation, which creates new
/// actions via MakeAction().
//<editor-fold defaultstate="collapsed" desc="clang::driver::Action">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 45,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", old_line = 41,
 FQN="clang::driver::Action", NM="_ZN5clang6driver6ActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver6ActionE")
//</editor-fold>
public class Action implements Iterable<Action/*P*/>, Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef ActionList::size_type size_type;
  // JAVA: typedef ActionList::iterator input_iterator
//  public final class input_iterator extends /*ActionList*/type$ptr<Action /*P*/>{ };
  // JAVA: typedef ActionList::const_iterator input_const_iterator
//  public final class input_const_iterator extends /*ActionList*/type$ptr<Action /*P*/>{ };
  // JAVA: typedef llvm::iterator_range<input_iterator> input_range
//  public final class input_range extends iterator_range<Action /*P*/ >{ };
  // JAVA: typedef llvm::iterator_range<input_const_iterator> input_const_range
//  public final class input_const_range extends iterator_range<Action /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::ActionClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 53,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", old_line = 47,
   FQN="clang::driver::Action::ActionClass", NM="_ZN5clang6driver6Action11ActionClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver6Action11ActionClassE")
  //</editor-fold>
  public enum ActionClass implements Native.NativeUIntEnum {
    InputClass(0),
    BindArchClass(InputClass.getValue() + 1),
    OffloadClass(BindArchClass.getValue() + 1),
    PreprocessJobClass(OffloadClass.getValue() + 1),
    PrecompileJobClass(PreprocessJobClass.getValue() + 1),
    AnalyzeJobClass(PrecompileJobClass.getValue() + 1),
    MigrateJobClass(AnalyzeJobClass.getValue() + 1),
    CompileJobClass(MigrateJobClass.getValue() + 1),
    BackendJobClass(CompileJobClass.getValue() + 1),
    AssembleJobClass(BackendJobClass.getValue() + 1),
    LinkJobClass(AssembleJobClass.getValue() + 1),
    LipoJobClass(LinkJobClass.getValue() + 1),
    DsymutilJobClass(LipoJobClass.getValue() + 1),
    VerifyDebugInfoJobClass(DsymutilJobClass.getValue() + 1),
    VerifyPCHJobClass(VerifyDebugInfoJobClass.getValue() + 1),
    
    JobClassFirst(ActionClass.PreprocessJobClass.getValue()),
    JobClassLast(ActionClass.VerifyPCHJobClass.getValue());

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ActionClass valueOf(int val) {
      ActionClass out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ActionClass[] VALUES;
      private static final ActionClass[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ActionClass kind : ActionClass.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ActionClass[min < 0 ? (1-min) : 0];
        VALUES = new ActionClass[max >= 0 ? (1+max) : 0];
        for (ActionClass kind : ActionClass.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private ActionClass(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  // The offloading kind determines if this action is binded to a particular
  // programming model. Each entry reserves one bit. We also have a special kind
  // to designate the host offloading tool chain.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::OffloadKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 77,
   FQN="clang::driver::Action::OffloadKind", NM="_ZN5clang6driver6Action11OffloadKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver6Action11OffloadKindE")
  //</editor-fold>
  public static final class/*enum*/ OffloadKind {
    public static final /*uint*/int OFK_None = 0x00;
    // The host offloading tool chain.
    public static final /*uint*/int OFK_Host = 0x01;
    // The device offloading tool chains - one bit for each programming model.
    public static final /*uint*/int OFK_Cuda = 0x02;
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::getClassName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 21,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", old_line = 20,
   FQN="clang::driver::Action::getClassName", NM="_ZN5clang6driver6Action12getClassNameENS1_11ActionClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver6Action12getClassNameENS1_11ActionClassE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getClassName(ActionClass AC) {
    switch (AC) {
     case InputClass:
      return $("input");
     case BindArchClass:
      return $("bind-arch");
     case OffloadClass:
      return $("offload");
     case PreprocessJobClass:
      return $("preprocessor");
     case PrecompileJobClass:
      return $("precompiler");
     case AnalyzeJobClass:
      return $("analyzer");
     case MigrateJobClass:
      return $("migrator");
     case CompileJobClass:
      return $("compiler");
     case BackendJobClass:
      return $("backend");
     case AssembleJobClass:
      return $("assembler");
     case LinkJobClass:
      return $("linker");
     case LipoJobClass:
      return $("lipo");
     case DsymutilJobClass:
      return $("dsymutil");
     case VerifyDebugInfoJobClass:
      return $("verify-debug-info");
     case VerifyPCHJobClass:
      return $("verify-pch");
    }
    throw new llvm_unreachable("invalid class");
  }

/*private:*/
  private ActionClass Kind;
  
  /// The output type of this action.
  private types.ID Type;
  
  private /*ActionList*/SmallVector<Action /*P*/> Inputs;
/*protected:*/
  ///
  /// Offload information.
  ///
  
  /// The host offloading kind - a combination of kinds encoded in a mask.
  /// Multiple programming models may be supported simultaneously by the same
  /// host.
  protected /*uint*/int ActiveOffloadKindMask/* = 0uU*/;
  /// Offloading kind of the device.
  protected /*OffloadKind*//*uint*/int OffloadingDeviceKind/* = OFK_None*/;
  /// The Offloading architecture associated with this action.
  protected /*const*/char$ptr/*char P*/ OffloadingArch/* = null*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::Action">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 109,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", old_line = 80,
   FQN="clang::driver::Action::Action", NM="_ZN5clang6driver6ActionC1ENS1_11ActionClassENS0_5types2IDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver6ActionC1ENS1_11ActionClassENS0_5types2IDE")
  //</editor-fold>
  protected Action(ActionClass Kind, types.ID Type) {
    // : Action(Kind, ActionList(), Type) 
    //START JInit
    /*ExprWithCleanups*/this(Kind, new /*ActionList*/SmallVector<Action /*P*/>(3, (Action/*P*/)null), Type);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::Action">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 110,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", old_line = 81,
   FQN="clang::driver::Action::Action", NM="_ZN5clang6driver6ActionC1ENS1_11ActionClassEPS1_NS0_5types2IDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver6ActionC1ENS1_11ActionClassEPS1_NS0_5types2IDE")
  //</editor-fold>
  protected Action(ActionClass Kind, Action /*P*/ Input, types.ID Type) {
    // : Action(Kind, ActionList({Input}), Type) 
    //START JInit
    /*ExprWithCleanups*/this(Kind, new /*ActionList*/SmallVector<Action /*P*/>(3, new Action /*P*/ /*const*/ [/*1*/] {Input}, (Action/*P*/)null), Type);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::Action">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 112,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", old_line = 83,
   FQN="clang::driver::Action::Action", NM="_ZN5clang6driver6ActionC1ENS1_11ActionClassEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver6ActionC1ENS1_11ActionClassEPS1_")
  //</editor-fold>
  protected Action(ActionClass Kind, Action /*P*/ Input) {
    // : Action(Kind, ActionList({Input}), Input->getType()) 
    //START JInit
    /*ExprWithCleanups*/this(Kind, new /*ActionList*/SmallVector<Action /*P*/>(3, new Action /*P*/ /*const*/ [/*1*/] {Input}, (Action/*P*/)null), Input.getType());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::Action">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 114,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", old_line = 85,
   FQN="clang::driver::Action::Action", NM="_ZN5clang6driver6ActionC1ENS1_11ActionClassERKN4llvm11SmallVectorIPS1_Lj3EEENS0_5types2IDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver6ActionC1ENS1_11ActionClassERKN4llvm11SmallVectorIPS1_Lj3EEENS0_5types2IDE")
  //</editor-fold>
  protected Action(ActionClass Kind, final /*const*//*ActionList*/SmallVector<Action /*P*/>/*&*/ Inputs, types.ID Type) {
    // : Kind(Kind), Type(Type), Inputs(Inputs), ActiveOffloadKindMask(0uU), OffloadingDeviceKind(OFK_None), OffloadingArch(null) 
    //START JInit
    this.Kind = Kind;
    this.Type = Type;
    this.Inputs = new /*ActionList*/SmallVector<Action /*P*/>(Inputs);
    /*InClass*/this.ActiveOffloadKindMask = 0/*U*/;
    /*InClass*/this.OffloadingDeviceKind = OffloadKind.OFK_None;
    /*InClass*/this.OffloadingArch = null;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::~Action">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 19,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", old_line = 18,
   FQN="clang::driver::Action::~Action", NM="_ZN5clang6driver6ActionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver6ActionD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    Inputs.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::getClassName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 120,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", old_line = 91,
   FQN="clang::driver::Action::getClassName", NM="_ZNK5clang6driver6Action12getClassNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver6Action12getClassNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getClassName() /*const*/ {
    return Action.getClassName(getKind());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 122,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", old_line = 93,
   FQN="clang::driver::Action::getKind", NM="_ZNK5clang6driver6Action7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver6Action7getKindEv")
  //</editor-fold>
  public ActionClass getKind() /*const*/ {
    return Kind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 123,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", old_line = 94,
   FQN="clang::driver::Action::getType", NM="_ZNK5clang6driver6Action7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver6Action7getTypeEv")
  //</editor-fold>
  public types.ID getType() /*const*/ {
    return Type;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::getInputs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 125,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", old_line = 96,
   FQN="clang::driver::Action::getInputs", NM="_ZN5clang6driver6Action9getInputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver6Action9getInputsEv")
  //</editor-fold>
  public /*ActionList*/SmallVector<Action /*P*/>/*&*/ getInputs() {
    return Inputs;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::getInputs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 126,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", old_line = 97,
   FQN="clang::driver::Action::getInputs", NM="_ZNK5clang6driver6Action9getInputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver6Action9getInputsEv")
  //</editor-fold>
  public /*const*//*ActionList*/SmallVector<Action /*P*/>/*&*/ getInputs$Const() /*const*/ {
    return Inputs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 128,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", old_line = 99,
   FQN="clang::driver::Action::size", NM="_ZNK5clang6driver6Action4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver6Action4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return Inputs.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::input_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 130,
   FQN="clang::driver::Action::input_begin", NM="_ZN5clang6driver6Action11input_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver6Action11input_beginEv")
  //</editor-fold>
  public /*ActionList*/type$ptr<Action /*P*/> input_begin() {
    return Inputs.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::input_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 131,
   FQN="clang::driver::Action::input_end", NM="_ZN5clang6driver6Action9input_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver6Action9input_endEv")
  //</editor-fold>
  public /*ActionList*/type$ptr<Action /*P*/> input_end() {
    return Inputs.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::inputs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 132,
   FQN="clang::driver::Action::inputs", NM="_ZN5clang6driver6Action6inputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver6Action6inputsEv")
  //</editor-fold>
  public iterator_range<Action /*P*/ > inputs() {
    return new iterator_range<Action /*P*/ >(input_begin(), input_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::input_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 133,
   FQN="clang::driver::Action::input_begin", NM="_ZNK5clang6driver6Action11input_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver6Action11input_beginEv")
  //</editor-fold>
  public /*ActionList*/type$ptr<Action /*P*/> input_begin$Const() /*const*/ {
    return Inputs.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::input_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 134,
   FQN="clang::driver::Action::input_end", NM="_ZNK5clang6driver6Action9input_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver6Action9input_endEv")
  //</editor-fold>
  public /*ActionList*/type$ptr<Action /*P*/> input_end$Const() /*const*/ {
    return Inputs.end$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::inputs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 135,
   FQN="clang::driver::Action::inputs", NM="_ZNK5clang6driver6Action6inputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver6Action6inputsEv")
  //</editor-fold>
  public iterator_range<Action /*P*/ /*const*/> inputs$Const() /*const*/ {
    return new iterator_range<Action /*P*/ /*const*/>(input_begin$Const(), input_end$Const());
  }


  /// Return a string containing the offload kind of the action.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::getOffloadingKindPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 81,
   FQN="clang::driver::Action::getOffloadingKindPrefix", NM="_ZNK5clang6driver6Action23getOffloadingKindPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver6Action23getOffloadingKindPrefixEv")
  //</editor-fold>
  public std.string getOffloadingKindPrefix() /*const*/ {
    switch (OffloadingDeviceKind) {
     case OffloadKind.OFK_None:
      break;
     case OffloadKind.OFK_Host:
      throw new llvm_unreachable("Host kind is not an offloading device kind.");
//      break;
     case OffloadKind.OFK_Cuda:
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"device-cuda");
      // TODO: Add other programming models here.
    }
    if (!(ActiveOffloadKindMask != 0)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
    }
    
    std.string Res/*J*/= new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"host");
    if (((ActiveOffloadKindMask & OffloadKind.OFK_Cuda) != 0)) {
      Res.$addassign_T$C$P(/*KEEP_STR*/"-cuda");
    }
    
    // TODO: Add other programming models here.
    return Res;
  }

  /// Return a string that can be used as prefix in order to generate unique
  /// files for each offloading kind.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::getOffloadingFileNamePrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 106,
   FQN="clang::driver::Action::getOffloadingFileNamePrefix", NM="_ZNK5clang6driver6Action27getOffloadingFileNamePrefixEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver6Action27getOffloadingFileNamePrefixEN4llvm9StringRefE")
  //</editor-fold>
  public std.string getOffloadingFileNamePrefix(StringRef NormalizedTriple) /*const*/ {
    // A file prefix is only generated for device actions and consists of the
    // offload kind and triple.
    if (!(OffloadingDeviceKind != 0)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
    }
    
    std.string Res/*J*/= new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$MINUS);
    Res.$addassign(getOffloadingKindPrefix());
    Res.$addassign_T$C$P(/*KEEP_STR*/"-");
    $addassign_string_StringRef(Res, /*NO_COPY*/NormalizedTriple);
    return Res;
  }

  
  /// Set the device offload info of this action and propagate it to its
  /// dependences.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::propagateDeviceOffloadInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 44,
   FQN="clang::driver::Action::propagateDeviceOffloadInfo", NM="_ZN5clang6driver6Action26propagateDeviceOffloadInfoENS1_11OffloadKindEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver6Action26propagateDeviceOffloadInfoENS1_11OffloadKindEPKc")
  //</editor-fold>
  public void propagateDeviceOffloadInfo(/*OffloadKind*//*uint*/int OKind, /*const*/char$ptr/*char P*/ OArch) {
    // Offload action set its own kinds on their dependences.
    if (Kind == ActionClass.OffloadClass) {
      return;
    }
    assert ((OffloadingDeviceKind == OKind || OffloadingDeviceKind == OffloadKind.OFK_None)) : "Setting device kind to a different device??";
    assert (!(ActiveOffloadKindMask != 0)) : "Setting a device kind in a host action??";
    OffloadingDeviceKind = OKind;
    OffloadingArch = $tryClone(OArch);
    
    for (Action /*P*/ A : Inputs)  {
      A.propagateDeviceOffloadInfo(OffloadingDeviceKind, OArch);
    }
  }

  /// Append the host offload info of this action and propagate it to its
  /// dependences.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::propagateHostOffloadInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 59,
   FQN="clang::driver::Action::propagateHostOffloadInfo", NM="_ZN5clang6driver6Action24propagateHostOffloadInfoEjPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver6Action24propagateHostOffloadInfoEjPKc")
  //</editor-fold>
  public void propagateHostOffloadInfo(/*uint*/int OKinds, /*const*/char$ptr/*char P*/ OArch) {
    // Offload action set its own kinds on their dependences.
    if (Kind == ActionClass.OffloadClass) {
      return;
    }
    assert (OffloadingDeviceKind == OffloadKind.OFK_None) : "Setting a host kind in a device action.";
    ActiveOffloadKindMask |= OKinds;
    OffloadingArch = $tryClone(OArch);
    
    for (Action /*P*/ A : Inputs)  {
      A.propagateHostOffloadInfo(ActiveOffloadKindMask, OArch);
    }
  }

  /// Set the offload info of this action to be the same as the provided action,
  /// and propagate it to its dependences.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::propagateOffloadInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 73,
   FQN="clang::driver::Action::propagateOffloadInfo", NM="_ZN5clang6driver6Action20propagateOffloadInfoEPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver6Action20propagateOffloadInfoEPKS1_")
  //</editor-fold>
  public void propagateOffloadInfo(/*const*/ Action /*P*/ A) {
    {
      /*uint*/int HK = A.getOffloadingHostActiveKinds();
      if ((HK != 0)) {
        propagateHostOffloadInfo(HK, A.getOffloadingArch());
      } else {
        propagateDeviceOffloadInfo(A.getOffloadingDeviceKind(), 
            A.getOffloadingArch());
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::getOffloadingHostActiveKinds">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 156,
   FQN="clang::driver::Action::getOffloadingHostActiveKinds", NM="_ZNK5clang6driver6Action28getOffloadingHostActiveKindsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver6Action28getOffloadingHostActiveKindsEv")
  //</editor-fold>
  public /*uint*/int getOffloadingHostActiveKinds() /*const*/ {
    return ActiveOffloadKindMask;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::getOffloadingDeviceKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 159,
   FQN="clang::driver::Action::getOffloadingDeviceKind", NM="_ZNK5clang6driver6Action23getOffloadingDeviceKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver6Action23getOffloadingDeviceKindEv")
  //</editor-fold>
  public /*OffloadKind*//*uint*/int getOffloadingDeviceKind() /*const*/ {
    return OffloadingDeviceKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::getOffloadingArch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 160,
   FQN="clang::driver::Action::getOffloadingArch", NM="_ZNK5clang6driver6Action17getOffloadingArchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver6Action17getOffloadingArchEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getOffloadingArch() /*const*/ {
    return OffloadingArch;
  }

  
  /// Check if this action have any offload kinds. Note that host offload kinds
  /// are only set if the action is a dependence to a host offload action.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::isHostOffloading">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 164,
   FQN="clang::driver::Action::isHostOffloading", NM="_ZNK5clang6driver6Action16isHostOffloadingENS1_11OffloadKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver6Action16isHostOffloadingENS1_11OffloadKindE")
  //</editor-fold>
  public boolean isHostOffloading(/*OffloadKind*//*uint*/int OKind) /*const*/ {
    return ((ActiveOffloadKindMask & OKind) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::isDeviceOffloading">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 167,
   FQN="clang::driver::Action::isDeviceOffloading", NM="_ZNK5clang6driver6Action18isDeviceOffloadingENS1_11OffloadKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver6Action18isDeviceOffloadingENS1_11OffloadKindE")
  //</editor-fold>
  public boolean isDeviceOffloading(/*OffloadKind*//*uint*/int OKind) /*const*/ {
    return OffloadingDeviceKind == OKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Action::isOffloading">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 170,
   FQN="clang::driver::Action::isOffloading", NM="_ZNK5clang6driver6Action12isOffloadingENS1_11OffloadKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver6Action12isOffloadingENS1_11OffloadKindE")
  //</editor-fold>
  public boolean isOffloading(/*OffloadKind*//*uint*/int OKind) /*const*/ {
    return isHostOffloading(OKind) || isDeviceOffloading(OKind);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public Iterator<Action/*P*/> iterator() {
    return Inputs.iterator();
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Type=" + Type // NOI18N
              + ", Inputs=" + Inputs // NOI18N
              + ", ActiveOffloadKindMask=" + ActiveOffloadKindMask // NOI18N
              + ", OffloadingDeviceKind=" + OffloadingDeviceKind // NOI18N
              + ", OffloadingArch=" + OffloadingArch; // NOI18N
  }
}

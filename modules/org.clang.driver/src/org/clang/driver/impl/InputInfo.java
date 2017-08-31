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

package org.clang.driver.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;


/// InputInfo - Wrapper for information about an input source.
//<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 23,
 FQN="clang::driver::InputInfo", NM="_ZN5clang6driver9InputInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfoE")
//</editor-fold>
public class InputInfo implements Native.NativePOD<InputInfo> {
  // FIXME: The distinction between filenames and inputarg here is
  // gross; we should probably drop the idea of a "linker
  // input". Doing so means tweaking pipelining to still create link
  // steps when it sees linker inputs (but not treat them as
  // arguments), and making sure that arguments get rendered
  // correctly.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::Class">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 30,
   FQN="clang::driver::InputInfo::Class", NM="_ZN5clang6driver9InputInfo5ClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfo5ClassE")
  //</editor-fold>
  private enum Class implements Native.ComparableLower {
    Nothing(0),
    Filename(Nothing.getValue() + 1),
    InputArg(Filename.getValue() + 1),
    Pipe(InputArg.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Class valueOf(int val) {
      Class out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Class[] VALUES;
      private static final Class[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Class kind : Class.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Class[min < 0 ? (1-min) : 0];
        VALUES = new Class[max >= 0 ? (1+max) : 0];
        for (Class kind : Class.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Class(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Class)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Class)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 37,
   FQN="clang::driver::InputInfo::(anonymous)", NM="_ZN5clang6driver9InputInfoE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfoE_Unnamed_union1")
  //</editor-fold>
  private static class/*union*/ Unnamed_union1 implements Native.NativePOD<Unnamed_union1>  {
    public /*const*/char$ptr/*char P*/ Filename;
    public /*const*/ Arg /*P*/ InputArg;
    
    //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 37,
     FQN="clang::driver::InputInfo::(anonymous union)::", NM="_ZN5clang6driver9InputInfoUt_C1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfoUt_C1ERKS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(Unnamed_union1 $Prm0) {
      $assign($Prm0);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 37,
     FQN="clang::driver::InputInfo::(anonymous union)::", NM="_ZN5clang6driver9InputInfoUt_C1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfoUt_C1EOS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(JD$Move _dparam, Unnamed_union1 $Prm0) {
      $assignMove($Prm0);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 37,
     FQN="clang::driver::InputInfo::(anonymous union)::", NM="_ZN5clang6driver9InputInfoUt_C1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfoUt_C1Ev")
    //</editor-fold>
    public /*inline*/ Unnamed_union1() {
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 37,
     FQN="clang::driver::InputInfo::(anonymous union)::operator=", NM="_ZN5clang6driver9InputInfoUt_aSERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfoUt_aSERKS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1 $assign(Unnamed_union1 $Prm0) {
      
      this.Filename = $tryClone($Prm0.Filename);
      
      this.InputArg = $Prm0.InputArg;
      
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 37,
     FQN="clang::driver::InputInfo::(anonymous union)::operator=", NM="_ZN5clang6driver9InputInfoUt_aSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfoUt_aSEOS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1 $assignMove(Unnamed_union1 $Prm0) {
      
      this.Filename = $tryClone($Prm0.Filename);
      
      this.InputArg = $Prm0.InputArg;
      
      return /*Deref*/this;
    }

    @Override
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public Unnamed_union1 clone() {
      return new Unnamed_union1(this);
    }
    
    @Override
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public boolean $eq(Unnamed_union1 other) {
      return this.InputArg == other.InputArg && Native.$eq_ptr(this.Filename, other.Filename);
    }
    
    public String toString() {
      return "" + "Filename=" + Filename // NOI18N
                + ", InputArg=" + InputArg; // NOI18N
    }
  };
  
  private Unnamed_union1 Data;
  private Class Kind;
  private /*const*/Action/*P*/ Act;
  private types.ID Type;
  private /*const*/char$ptr/*char P*/ BaseInput;
  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::GetActionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 46,
   FQN="clang::driver::InputInfo::GetActionType", NM="_ZN5clang6driver9InputInfo13GetActionTypeEPKNS0_6ActionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfo13GetActionTypeEPKNS0_6ActionE")
  //</editor-fold>
  private static types.ID GetActionType(/*const*/Action/*P*/ A) {
    return A != null ? A.getType() : types.ID.TY_Nothing;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::InputInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 51,
   FQN="clang::driver::InputInfo::InputInfo", NM="_ZN5clang6driver9InputInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfoC1Ev")
  //</editor-fold>
  public InputInfo() {
    /* : InputInfo(null, null)*/ 
    //START JInit
    this((/*const*/Action/*P*/ )null, (/*const*/char$ptr/*char P*/ )null);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::InputInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 52,
   FQN="clang::driver::InputInfo::InputInfo", NM="_ZN5clang6driver9InputInfoC1EPKNS0_6ActionEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfoC1EPKNS0_6ActionEPKc")
  //</editor-fold>
  public InputInfo(/*const*/Action/*P*/ A, /*const*/char$ptr/*char P*/ _BaseInput) {
    /* : Data(), Kind(Nothing), Act(A), Type(GetActionType(A)), BaseInput(_BaseInput)*/ 
    //START JInit
    this.Data = new Unnamed_union1();
    this.Kind = Class.Nothing;
    this.Act = A;
    this.Type = GetActionType(A);
    this.BaseInput = $tryClone(_BaseInput);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::InputInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 55,
   FQN="clang::driver::InputInfo::InputInfo", NM="_ZN5clang6driver9InputInfoC1ENS0_5types2IDEPKcS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfoC1ENS0_5types2IDEPKcS5_")
  //</editor-fold>
  public InputInfo(types.ID _Type, /*const*/char$ptr/*char P*/ _Filename, /*const*/char$ptr/*char P*/ _BaseInput) {
    /* : Data(), Kind(Filename), Act(null), Type(_Type), BaseInput(_BaseInput)*/ 
    //START JInit
    this.Data = new Unnamed_union1();
    this.Kind = Class.Filename;
    this.Act = null;
    this.Type = _Type;
    this.BaseInput = $tryClone(_BaseInput);
    //END JInit
    Data.Filename = $tryClone(_Filename);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::InputInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 59,
   FQN="clang::driver::InputInfo::InputInfo", NM="_ZN5clang6driver9InputInfoC1EPKNS0_6ActionEPKcS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfoC1EPKNS0_6ActionEPKcS6_")
  //</editor-fold>
  public InputInfo(/*const*/Action/*P*/ A, /*const*/char$ptr/*char P*/ _Filename, /*const*/char$ptr/*char P*/ _BaseInput) {
    /* : Data(), Kind(Filename), Act(A), Type(GetActionType(A)), BaseInput(_BaseInput)*/ 
    //START JInit
    this.Data = new Unnamed_union1();
    this.Kind = Class.Filename;
    this.Act = A;
    this.Type = GetActionType(A);
    this.BaseInput = $tryClone(_BaseInput);
    //END JInit
    Data.Filename = $tryClone(_Filename);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::InputInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 64,
   FQN="clang::driver::InputInfo::InputInfo", NM="_ZN5clang6driver9InputInfoC1ENS0_5types2IDEPKN4llvm3opt3ArgEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfoC1ENS0_5types2IDEPKN4llvm3opt3ArgEPKc")
  //</editor-fold>
  public InputInfo(types.ID _Type, /*const*/ Arg /*P*/ _InputArg, 
      /*const*/char$ptr/*char P*/ _BaseInput) {
    /* : Data(), Kind(InputArg), Act(null), Type(_Type), BaseInput(_BaseInput)*/ 
    //START JInit
    this.Data = new Unnamed_union1();
    this.Kind = Class.InputArg;
    this.Act = null;
    this.Type = _Type;
    this.BaseInput = $tryClone(_BaseInput);
    //END JInit
    Data.InputArg = _InputArg;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::InputInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 69,
   FQN="clang::driver::InputInfo::InputInfo", NM="_ZN5clang6driver9InputInfoC1EPKNS0_6ActionEPKN4llvm3opt3ArgEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfoC1EPKNS0_6ActionEPKN4llvm3opt3ArgEPKc")
  //</editor-fold>
  public InputInfo(/*const*/Action/*P*/ A, /*const*/ Arg /*P*/ _InputArg, 
      /*const*/char$ptr/*char P*/ _BaseInput) {
    /* : Data(), Kind(InputArg), Act(A), Type(GetActionType(A)), BaseInput(_BaseInput)*/ 
    //START JInit
    this.Data = new Unnamed_union1();
    this.Kind = Class.InputArg;
    this.Act = A;
    this.Type = GetActionType(A);
    this.BaseInput = $tryClone(_BaseInput);
    //END JInit
    Data.InputArg = _InputArg;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::isNothing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 75,
   FQN="clang::driver::InputInfo::isNothing", NM="_ZNK5clang6driver9InputInfo9isNothingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver9InputInfo9isNothingEv")
  //</editor-fold>
  public boolean isNothing() /*const*/ {
    return Kind == Class.Nothing;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::isFilename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 76,
   FQN="clang::driver::InputInfo::isFilename", NM="_ZNK5clang6driver9InputInfo10isFilenameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver9InputInfo10isFilenameEv")
  //</editor-fold>
  public boolean isFilename() /*const*/ {
    return Kind == Class.Filename;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::isInputArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 77,
   FQN="clang::driver::InputInfo::isInputArg", NM="_ZNK5clang6driver9InputInfo10isInputArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver9InputInfo10isInputArgEv")
  //</editor-fold>
  public boolean isInputArg() /*const*/ {
    return Kind == Class.InputArg;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 78,
   FQN="clang::driver::InputInfo::getType", NM="_ZNK5clang6driver9InputInfo7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver9InputInfo7getTypeEv")
  //</editor-fold>
  public types.ID getType() /*const*/ {
    return Type;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::getBaseInput">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 79,
   FQN="clang::driver::InputInfo::getBaseInput", NM="_ZNK5clang6driver9InputInfo12getBaseInputEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver9InputInfo12getBaseInputEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getBaseInput() /*const*/ {
    return BaseInput;
  }

  /// The action for which this InputInfo was created.  May be null.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::getAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 81,
   FQN="clang::driver::InputInfo::getAction", NM="_ZNK5clang6driver9InputInfo9getActionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver9InputInfo9getActionEv")
  //</editor-fold>
  public /*const*/Action/*P*/ getAction() /*const*/ {
    return Act;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::setAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 82,
   FQN="clang::driver::InputInfo::setAction", NM="_ZN5clang6driver9InputInfo9setActionEPKNS0_6ActionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfo9setActionEPKNS0_6ActionE")
  //</editor-fold>
  public void setAction(/*const*/Action/*P*/ A) {
    Act = A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::getFilename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 84,
   FQN="clang::driver::InputInfo::getFilename", NM="_ZNK5clang6driver9InputInfo11getFilenameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver9InputInfo11getFilenameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getFilename() /*const*/ {
    assert (isFilename()) : "Invalid accessor.";
    return Data.Filename;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::getInputArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 88,
   FQN="clang::driver::InputInfo::getInputArg", NM="_ZNK5clang6driver9InputInfo11getInputArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver9InputInfo11getInputArgEv")
  //</editor-fold>
  public /*const*/ Arg /*&*/ getInputArg() /*const*/ {
    assert (isInputArg()) : "Invalid accessor.";
    return /*Deref*/Data.InputArg;
  }

  
  /// getAsString - Return a string name for this input, for
  /// debugging.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::getAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 95,
   FQN="clang::driver::InputInfo::getAsString", NM="_ZNK5clang6driver9InputInfo11getAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver9InputInfo11getAsStringEv")
  //</editor-fold>
  public std.string getAsString() /*const*/ {
    if (isFilename()) {
      return $add_string_T($add_string_T(new std.string(/*KEEP_STR*/$DBL_QUOTE), getFilename()), $$DBL_QUOTE);
    } else if (isInputArg()) {
      return new std.string(/*KEEP_STR*/"(input arg)");
    } else {
      return new std.string(/*KEEP_STR*/"(nothing)");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::InputInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 23,
   FQN="clang::driver::InputInfo::InputInfo", NM="_ZN5clang6driver9InputInfoC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfoC1ERKS1_")
  //</editor-fold>
  public /*inline*/ InputInfo(/*const*/ InputInfo /*&*/ $Prm0) {
    /* : Data(.Data), Kind(.Kind), Act(.Act), Type(.Type), BaseInput(.BaseInput)*/ 
    //START JInit
    this.Data = new Unnamed_union1($Prm0.Data);
    this.Kind = $Prm0.Kind;
    this.Act = $Prm0.Act;
    this.Type = $Prm0.Type;
    this.BaseInput = $tryClone($Prm0.BaseInput);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::InputInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 23,
   FQN="clang::driver::InputInfo::InputInfo", NM="_ZN5clang6driver9InputInfoC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfoC1EOS1_")
  //</editor-fold>
  public /*inline*/ InputInfo(JD$Move _dparam, InputInfo /*&&*/$Prm0) {
    /* : Data(static_cast<InputInfo &&>().Data), Kind(static_cast<InputInfo &&>().Kind), Act(static_cast<InputInfo &&>().Act), Type(static_cast<InputInfo &&>().Type), BaseInput(static_cast<InputInfo &&>().BaseInput)*/ 
    //START JInit
    this.Data = new Unnamed_union1(JD$Move.INSTANCE, $Prm0.Data);
    this.Kind = $Prm0.Kind;
    this.Act = $Prm0.Act;
    this.Type = $Prm0.Type;
    this.BaseInput = $tryClone($Prm0.BaseInput);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 23,
   FQN="clang::driver::InputInfo::operator=", NM="_ZN5clang6driver9InputInfoaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfoaSERKS1_")
  //</editor-fold>
  public /*inline*/ InputInfo /*&*/ $assign(/*const*/ InputInfo /*&*/ $Prm0) {
    this.Data.$assign($Prm0.Data);
    this.Kind = $Prm0.Kind;
    this.Act = $Prm0.Act;
    this.Type = $Prm0.Type;
    this.BaseInput = $tryClone($Prm0.BaseInput);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::InputInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/InputInfo.h", line = 23,
   FQN="clang::driver::InputInfo::operator=", NM="_ZN5clang6driver9InputInfoaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver9InputInfoaSEOS1_")
  //</editor-fold>
  public /*inline*/ InputInfo /*&*/ $assignMove(InputInfo /*&&*/$Prm0) {
    this.Data.$assignMove($Prm0.Data);
    this.Kind = $Prm0.Kind;
    this.Act = $Prm0.Act;
    this.Type = $Prm0.Type;
    this.BaseInput = $tryClone($Prm0.BaseInput);
    return /*Deref*/this;
  }

  @Override
  @SuppressWarnings({"CloneDeclaresCloneNotSupported", "CloneDoesntCallSuperClone"})
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public InputInfo clone() {
    return new InputInfo(this);
  }
  
  @Override
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public boolean $eq(InputInfo other) {
    return this.Type == other.Type && this.Kind == other.Kind &&
            this.Data.$eq(other.Data) && Native.$eq_ptr(this.BaseInput, other.BaseInput);
  } 
  
  public String toString() {
    return "" + "Data=" + Data // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", Act=" + Act // NOI18N
              + ", Type=" + Type // NOI18N
              + ", BaseInput=" + BaseInput; // NOI18N
  }
}

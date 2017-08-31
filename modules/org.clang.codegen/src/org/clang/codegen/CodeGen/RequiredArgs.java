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

package org.clang.codegen.CodeGen;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;


/// A class for recording the number of arguments that a function
/// signature requires.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RequiredArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 381,
 FQN="clang::CodeGen::RequiredArgs", NM="_ZN5clang7CodeGen12RequiredArgsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12RequiredArgsE")
//</editor-fold>
public class RequiredArgs {
  /// The number of required arguments, or ~0 if the signature does
  /// not permit optional arguments.
  private /*uint*/int NumRequired;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RequiredArgs::All_t">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 386,
   FQN="clang::CodeGen::RequiredArgs::All_t", NM="_ZN5clang7CodeGen12RequiredArgs5All_tE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12RequiredArgs5All_tE")
  //</editor-fold>
  public enum All_t implements Native.NativeUIntEnum {
    All(0);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static All_t valueOf(int val) {
      All_t out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final All_t[] VALUES;
      private static final All_t[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (All_t kind : All_t.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new All_t[min < 0 ? (1-min) : 0];
        VALUES = new All_t[max >= 0 ? (1+max) : 0];
        for (All_t kind : All_t.values()) {
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
    private All_t(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RequiredArgs::RequiredArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 388,
   FQN="clang::CodeGen::RequiredArgs::RequiredArgs", NM="_ZN5clang7CodeGen12RequiredArgsC1ENS1_5All_tE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12RequiredArgsC1ENS1_5All_tE")
  //</editor-fold>
  public RequiredArgs(All_t _) {
    // : NumRequired(~0UU) 
    //START JInit
    this.NumRequired = ~0/*U*/;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RequiredArgs::RequiredArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 389,
   FQN="clang::CodeGen::RequiredArgs::RequiredArgs", NM="_ZN5clang7CodeGen12RequiredArgsC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12RequiredArgsC1Ej")
  //</editor-fold>
  public /*explicit*/ RequiredArgs(/*uint*/int n) {
    // : NumRequired(n) 
    //START JInit
    this.NumRequired = n;
    //END JInit
    assert (n != ~0/*U*/);
  }

  
  /// Compute the arguments required by the given formal prototype,
  /// given that there may be some additional, non-formal arguments
  /// in play.
  ///
  /// If FD is not null, this will consider pass_object_size params in FD.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RequiredArgs::forPrototypePlus">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 398,
   FQN="clang::CodeGen::RequiredArgs::forPrototypePlus", NM="_ZN5clang7CodeGen12RequiredArgs16forPrototypePlusEPKNS_17FunctionProtoTypeEjPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12RequiredArgs16forPrototypePlusEPKNS_17FunctionProtoTypeEjPKNS_12FunctionDeclE")
  //</editor-fold>
  public static RequiredArgs forPrototypePlus(/*const*/ FunctionProtoType /*P*/ prototype, 
                  /*uint*/int additional, 
                  /*const*/ FunctionDecl /*P*/ FD) {
    if (!prototype.isVariadic()) {
      return new RequiredArgs(All_t.All);
    }
    if ((FD != null)) {
      throw new UnsupportedOperationException();
      //additional += AdtsupportLlvmGlobals.count_if(FD.parameters$Const(), /*[]*/ (/*const*/ ParmVarDecl /*P*/ PVD) -> {
      //          return PVD.hasAttr(PassObjectSizeAttr.class);
      //        });
    }
    return new RequiredArgs(prototype.getNumParams() + additional);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RequiredArgs::forPrototype">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 410,
   FQN="clang::CodeGen::RequiredArgs::forPrototype", NM="_ZN5clang7CodeGen12RequiredArgs12forPrototypeEPKNS_17FunctionProtoTypeEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12RequiredArgs12forPrototypeEPKNS_17FunctionProtoTypeEPKNS_12FunctionDeclE")
  //</editor-fold>
  public static RequiredArgs forPrototype(/*const*/ FunctionProtoType /*P*/ prototype, 
              /*const*/ FunctionDecl /*P*/ FD) {
    return RequiredArgs.forPrototypePlus(prototype, 0, FD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RequiredArgs::forPrototype">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 415,
   FQN="clang::CodeGen::RequiredArgs::forPrototype", NM="_ZN5clang7CodeGen12RequiredArgs12forPrototypeENS_7CanQualINS_17FunctionProtoTypeEEEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12RequiredArgs12forPrototypeENS_7CanQualINS_17FunctionProtoTypeEEEPKNS_12FunctionDeclE")
  //</editor-fold>
  public static RequiredArgs forPrototype(CanQual<FunctionProtoType> prototype, 
              /*const*/ FunctionDecl /*P*/ FD) {
    return RequiredArgs.forPrototype(prototype.getTypePtr(), FD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RequiredArgs::forPrototypePlus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 420,
   FQN="clang::CodeGen::RequiredArgs::forPrototypePlus", NM="_ZN5clang7CodeGen12RequiredArgs16forPrototypePlusENS_7CanQualINS_17FunctionProtoTypeEEEjPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12RequiredArgs16forPrototypePlusENS_7CanQualINS_17FunctionProtoTypeEEEjPKNS_12FunctionDeclE")
  //</editor-fold>
  public static RequiredArgs forPrototypePlus(CanQual<FunctionProtoType> prototype, 
                  /*uint*/int additional, 
                  /*const*/ FunctionDecl /*P*/ FD) {
    return RequiredArgs.forPrototypePlus(prototype.getTypePtr(), additional, FD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RequiredArgs::allowsOptionalArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 426,
   FQN="clang::CodeGen::RequiredArgs::allowsOptionalArgs", NM="_ZNK5clang7CodeGen12RequiredArgs18allowsOptionalArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12RequiredArgs18allowsOptionalArgsEv")
  //</editor-fold>
  public boolean allowsOptionalArgs() /*const*/ {
    return NumRequired != ~0/*U*/;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RequiredArgs::getNumRequiredArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 427,
   FQN="clang::CodeGen::RequiredArgs::getNumRequiredArgs", NM="_ZNK5clang7CodeGen12RequiredArgs18getNumRequiredArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12RequiredArgs18getNumRequiredArgsEv")
  //</editor-fold>
  public /*uint*/int getNumRequiredArgs() /*const*/ {
    assert (allowsOptionalArgs());
    return NumRequired;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RequiredArgs::getOpaqueData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 432,
   FQN="clang::CodeGen::RequiredArgs::getOpaqueData", NM="_ZNK5clang7CodeGen12RequiredArgs13getOpaqueDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12RequiredArgs13getOpaqueDataEv")
  //</editor-fold>
  public /*uint*/int getOpaqueData() /*const*/ {
    return NumRequired;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RequiredArgs::getFromOpaqueData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 433,
   FQN="clang::CodeGen::RequiredArgs::getFromOpaqueData", NM="_ZN5clang7CodeGen12RequiredArgs17getFromOpaqueDataEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12RequiredArgs17getFromOpaqueDataEj")
  //</editor-fold>
  public static RequiredArgs getFromOpaqueData(/*uint*/int value) {
    if (value == ~0/*U*/) {
      return new RequiredArgs(All_t.All);
    }
    return new RequiredArgs(value);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RequiredArgs::RequiredArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 381,
   FQN="clang::CodeGen::RequiredArgs::RequiredArgs", NM="_ZN5clang7CodeGen12RequiredArgsC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12RequiredArgsC1ERKS1_")
  //</editor-fold>
  public /*inline*/ RequiredArgs(final /*const*/ RequiredArgs /*&*/ $Prm0) {
    // : NumRequired(.NumRequired) 
    //START JInit
    this.NumRequired = $Prm0.NumRequired;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RequiredArgs::RequiredArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 381,
   FQN="clang::CodeGen::RequiredArgs::RequiredArgs", NM="_ZN5clang7CodeGen12RequiredArgsC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12RequiredArgsC1EOS1_")
  //</editor-fold>
  public /*inline*/ RequiredArgs(JD$Move _dparam, final RequiredArgs /*&&*/$Prm0) {
    // : NumRequired(static_cast<RequiredArgs &&>().NumRequired) 
    //START JInit
    this.NumRequired = $Prm0.NumRequired;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RequiredArgs::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 381,
   FQN="clang::CodeGen::RequiredArgs::operator=", NM="_ZN5clang7CodeGen12RequiredArgsaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12RequiredArgsaSERKS1_")
  //</editor-fold>
  public /*inline*/ RequiredArgs /*&*/ $assign(final /*const*/ RequiredArgs /*&*/ $Prm0) {
    this.NumRequired = $Prm0.NumRequired;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RequiredArgs::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 381,
   FQN="clang::CodeGen::RequiredArgs::operator=", NM="_ZN5clang7CodeGen12RequiredArgsaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12RequiredArgsaSEOS1_")
  //</editor-fold>
  public /*inline*/ RequiredArgs /*&*/ $assignMove(final RequiredArgs /*&&*/$Prm0) {
    this.NumRequired = $Prm0.NumRequired;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "NumRequired=" + NumRequired; // NOI18N
  }
}

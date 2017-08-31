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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// FunctionType - C99 6.7.5.3 - Function Declarators.  This is the common base
/// class of FunctionNoProtoType and FunctionProtoType.
///
//<editor-fold defaultstate="collapsed" desc="clang::FunctionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2879,
 FQN="clang::FunctionType", NM="_ZN5clang12FunctionTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang12FunctionTypeE")
//</editor-fold>
public class FunctionType extends /*public*/ Type {
  // The type returned by the function.
  private QualType ResultType;
/*public:*/
  /// A class which abstracts out some details necessary for
  /// making a call.
  ///
  /// It is not actually used directly for storing this information in
  /// a FunctionType, although FunctionType does currently use the
  /// same bit-pattern.
  ///
  // If you add a field (say Foo), other than the obvious places (both,
  // constructors, compile failures), what you need to update is
  // * Operator==
  // * getFoo
  // * withFoo
  // * functionType. Add Foo, getFoo.
  // * ASTContext::getFooType
  // * ASTContext::mergeFunctionTypes
  // * FunctionNoProtoType::Profile
  // * FunctionProtoType::Profile
  // * TypePrinter::PrintFunctionProto
  // * AST read and write
  // * Codegen
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2904,
   FQN="clang::FunctionType::ExtInfo", NM="_ZN5clang12FunctionType7ExtInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang12FunctionType7ExtInfoE")
  //</editor-fold>
  public static class ExtInfo implements Native.NativeComparable<ExtInfo> {
    // Feel free to rearrange or add bits, but if you go over 9,
    // you'll need to adjust both the Bits field below and
    // Type::FunctionTypeBitfields.
    
    //   |  CC  |noreturn|produces|regparm|
    //   |0 .. 3|   4    |    5   | 6 .. 8|
    //
    // regparm is either 0 (no regparm attribute) or the regparm value+1.
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2913,
     FQN="clang::FunctionType::ExtInfo::(anonymous)", NM="_ZN5clang12FunctionType7ExtInfoE_Unnamed_enum",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang12FunctionType7ExtInfoE_Unnamed_enum")
    //</editor-fold>
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      public static final /*uint*/int CallConvMask = 0xF;
    /*}*/;
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2914,
     FQN="clang::FunctionType::ExtInfo::(anonymous)", NM="_ZN5clang12FunctionType7ExtInfoE_Unnamed_enum1",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang12FunctionType7ExtInfoE_Unnamed_enum1")
    //</editor-fold>
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      public static final /*uint*/int NoReturnMask = 0x10;
    /*}*/;
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2915,
     FQN="clang::FunctionType::ExtInfo::(anonymous)", NM="_ZN5clang12FunctionType7ExtInfoE_Unnamed_enum2",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang12FunctionType7ExtInfoE_Unnamed_enum2")
    //</editor-fold>
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      public static final /*uint*/int ProducesResultMask = 0x20;
    /*}*/;
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2916,
     FQN="clang::FunctionType::ExtInfo::(anonymous)", NM="_ZN5clang12FunctionType7ExtInfoE_Unnamed_enum3",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang12FunctionType7ExtInfoE_Unnamed_enum3")
    //</editor-fold>
    private enum Unnamed_enum3 implements Native.ComparableLower {
      RegParmMask(~(CallConvMask | NoReturnMask | ProducesResultMask)),
      RegParmOffset(6);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static Unnamed_enum3 valueOf(int val) {
        Unnamed_enum3 out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final Unnamed_enum3[] VALUES;
        private static final Unnamed_enum3[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (Unnamed_enum3 kind : Unnamed_enum3.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new Unnamed_enum3[min < 0 ? (1-min) : 0];
          VALUES = new Unnamed_enum3[max >= 0 ? (1+max) : 0];
          for (Unnamed_enum3 kind : Unnamed_enum3.values()) {
            if (kind.value < 0) {
              _VALUES[-kind.value] = kind;
            } else {
              VALUES[kind.value] = kind;
            }
          }
        }
      }

      private final int value;
      private Unnamed_enum3(int val) { this.value = (int)val;}
      public int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_int(value, ((Unnamed_enum3)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_int(value, ((Unnamed_enum3)obj).value);}
      //</editor-fold>
    };
    // Assumed to be the last field
    private /*uint16_t*/char Bits;
    
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::ExtInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2921,
     FQN="clang::FunctionType::ExtInfo::ExtInfo", NM="_ZN5clang12FunctionType7ExtInfoC1Ej",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang12FunctionType7ExtInfoC1Ej")
    //</editor-fold>
    /*friend*//*package*/ ExtInfo(/*uint*/int Bits) {
      // : Bits(static_cast<uint16_t>(Bits)) 
      //START JInit
      this.Bits = ((/*static_cast*//*uint16_t*/char)($uint2ushort(Bits)));
      //END JInit
    }

    
    /*friend  class FunctionType*/
  /*public:*/
    // Constructor with no defaults. Use this when you know that you
    // have all the elements (when reading an AST file for example).
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::ExtInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2928,
     FQN="clang::FunctionType::ExtInfo::ExtInfo", NM="_ZN5clang12FunctionType7ExtInfoC1EbbjNS_11CallingConvEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang12FunctionType7ExtInfoC1EbbjNS_11CallingConvEb")
    //</editor-fold>
    /*friend*/public/*public*/ ExtInfo(boolean noReturn, boolean hasRegParm, /*uint*/int regParm, CallingConv cc, 
        boolean producesResult) {
      assert ((!hasRegParm || $less_uint(regParm, 7))) : "Invalid regparm value";
      Bits = $uint2ushort(((/*uint*/int)cc.getValue())
         | (noReturn ? NoReturnMask : 0)
         | (producesResult ? ProducesResultMask : 0)
         | (hasRegParm ? ((regParm + 1) << Unnamed_enum3.RegParmOffset.getValue()) : 0));
    }

    
    // Constructor with all defaults. Use when for example creating a
    // function known to use defaults.
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::ExtInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2939,
     FQN="clang::FunctionType::ExtInfo::ExtInfo", NM="_ZN5clang12FunctionType7ExtInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang12FunctionType7ExtInfoC1Ev")
    //</editor-fold>
    public ExtInfo() {
      // : Bits(CC_C) 
      //START JInit
      this.Bits = $int2ushort(CallingConv.CC_C.getValue());
      //END JInit
    }

    
    // Constructor with just the calling convention, which is an important part
    // of the canonical type.
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::ExtInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2943,
     FQN="clang::FunctionType::ExtInfo::ExtInfo", NM="_ZN5clang12FunctionType7ExtInfoC1ENS_11CallingConvE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang12FunctionType7ExtInfoC1ENS_11CallingConvE")
    //</editor-fold>
    public ExtInfo(CallingConv CC) {
      // : Bits(CC) 
      //START JInit
      this.Bits = $int2ushort(CC.getValue());
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::getNoReturn">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2945,
     FQN="clang::FunctionType::ExtInfo::getNoReturn", NM="_ZNK5clang12FunctionType7ExtInfo11getNoReturnEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType7ExtInfo11getNoReturnEv")
    //</editor-fold>
    public boolean getNoReturn() /*const*/ {
      return (($ushort2int(Bits) & NoReturnMask) != 0);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::getProducesResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2946,
     FQN="clang::FunctionType::ExtInfo::getProducesResult", NM="_ZNK5clang12FunctionType7ExtInfo17getProducesResultEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType7ExtInfo17getProducesResultEv")
    //</editor-fold>
    public boolean getProducesResult() /*const*/ {
      return (($ushort2int(Bits) & ProducesResultMask) != 0);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::getHasRegParm">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2947,
     FQN="clang::FunctionType::ExtInfo::getHasRegParm", NM="_ZNK5clang12FunctionType7ExtInfo13getHasRegParmEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType7ExtInfo13getHasRegParmEv")
    //</editor-fold>
    public boolean getHasRegParm() /*const*/ {
      return ($ushort2int(Bits) >> Unnamed_enum3.RegParmOffset.getValue()) != 0;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::getRegParm">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2948,
     FQN="clang::FunctionType::ExtInfo::getRegParm", NM="_ZNK5clang12FunctionType7ExtInfo10getRegParmEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType7ExtInfo10getRegParmEv")
    //</editor-fold>
    public /*uint*/int getRegParm() /*const*/ {
      /*uint*/int RegParm = $ushort2int(Bits) >> Unnamed_enum3.RegParmOffset.getValue();
      if ($greater_uint(RegParm, 0)) {
        --RegParm;
      }
      return RegParm;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::getCC">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2954,
     FQN="clang::FunctionType::ExtInfo::getCC", NM="_ZNK5clang12FunctionType7ExtInfo5getCCEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType7ExtInfo5getCCEv")
    //</editor-fold>
    public CallingConv getCC() /*const*/ {
      return CallingConv.valueOf($ushort2int(Bits) & CallConvMask);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2956,
     FQN="clang::FunctionType::ExtInfo::operator==", NM="_ZNK5clang12FunctionType7ExtInfoeqES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType7ExtInfoeqES1_")
    //</editor-fold>
    public boolean $eq(ExtInfo Other) /*const*/ {
      return $ushort2int(Bits) == $ushort2int(Other.Bits);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2959,
     FQN="clang::FunctionType::ExtInfo::operator!=", NM="_ZNK5clang12FunctionType7ExtInfoneES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType7ExtInfoneES1_")
    //</editor-fold>
    public boolean $noteq(ExtInfo Other) /*const*/ {
      return $ushort2int(Bits) != $ushort2int(Other.Bits);
    }

    
    // Note that we don't have setters. That is by design, use
    // the following with methods instead of mutating these objects.
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::withNoReturn">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2966,
     FQN="clang::FunctionType::ExtInfo::withNoReturn", NM="_ZNK5clang12FunctionType7ExtInfo12withNoReturnEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType7ExtInfo12withNoReturnEb")
    //</editor-fold>
    public ExtInfo withNoReturn(boolean noReturn) /*const*/ {
      if (noReturn) {
        return new ExtInfo($ushort2int(Bits) | NoReturnMask);
      } else {
        return new ExtInfo($ushort2int(Bits) & ~NoReturnMask);
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::withProducesResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2973,
     FQN="clang::FunctionType::ExtInfo::withProducesResult", NM="_ZNK5clang12FunctionType7ExtInfo18withProducesResultEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType7ExtInfo18withProducesResultEb")
    //</editor-fold>
    public ExtInfo withProducesResult(boolean producesResult) /*const*/ {
      if (producesResult) {
        return new ExtInfo($ushort2int(Bits) | ProducesResultMask);
      } else {
        return new ExtInfo($ushort2int(Bits) & ~ProducesResultMask);
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::withRegParm">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2980,
     FQN="clang::FunctionType::ExtInfo::withRegParm", NM="_ZNK5clang12FunctionType7ExtInfo11withRegParmEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType7ExtInfo11withRegParmEj")
    //</editor-fold>
    public ExtInfo withRegParm(/*uint*/int RegParm) /*const*/ {
      assert ($less_uint(RegParm, 7)) : "Invalid regparm value";
      return new ExtInfo(($ushort2int(Bits) & ~Unnamed_enum3.RegParmMask.getValue())
             | ((RegParm + 1) << Unnamed_enum3.RegParmOffset.getValue()));
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::withCallingConv">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2986,
     FQN="clang::FunctionType::ExtInfo::withCallingConv", NM="_ZNK5clang12FunctionType7ExtInfo15withCallingConvENS_11CallingConvE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType7ExtInfo15withCallingConvENS_11CallingConvE")
    //</editor-fold>
    public ExtInfo withCallingConv(CallingConv cc) /*const*/ {
      return new ExtInfo(($ushort2int(Bits) & ~CallConvMask) | (/*uint*/int)cc.getValue());
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::Profile">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2990,
     FQN="clang::FunctionType::ExtInfo::Profile", NM="_ZNK5clang12FunctionType7ExtInfo7ProfileERN4llvm16FoldingSetNodeIDE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType7ExtInfo7ProfileERN4llvm16FoldingSetNodeIDE")
    //</editor-fold>
    public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
      ID.AddInteger_int($ushort2int(Bits));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::ExtInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2904,
     FQN="clang::FunctionType::ExtInfo::ExtInfo", NM="_ZN5clang12FunctionType7ExtInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang12FunctionType7ExtInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ ExtInfo(final /*const*/ ExtInfo /*&*/ $Prm0) {
      // : Bits(.Bits) 
      //START JInit
      this.Bits = $Prm0.Bits;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::ExtInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2904,
     FQN="clang::FunctionType::ExtInfo::ExtInfo", NM="_ZN5clang12FunctionType7ExtInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang12FunctionType7ExtInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ ExtInfo(JD$Move _dparam, final ExtInfo /*&&*/$Prm0) {
      // : Bits(static_cast<ExtInfo &&>().Bits) 
      //START JInit
      this.Bits = $Prm0.Bits;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2904,
     FQN="clang::FunctionType::ExtInfo::operator=", NM="_ZN5clang12FunctionType7ExtInfoaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang12FunctionType7ExtInfoaSERKS1_")
    //</editor-fold>
    public /*inline*/ ExtInfo /*&*/ $assign(final /*const*/ ExtInfo /*&*/ $Prm0) {
      this.Bits = $Prm0.Bits;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::ExtInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2904,
     FQN="clang::FunctionType::ExtInfo::operator=", NM="_ZN5clang12FunctionType7ExtInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang12FunctionType7ExtInfoaSEOS1_")
    //</editor-fold>
    public /*inline*/ ExtInfo /*&*/ $assignMove(final ExtInfo /*&&*/$Prm0) {
      this.Bits = $Prm0.Bits;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "Bits=" + $ushort2uint(Bits); // NOI18N
    }
  };
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::FunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2996,
   FQN="clang::FunctionType::FunctionType", NM="_ZN5clang12FunctionTypeC1ENS_4Type9TypeClassENS_8QualTypeES3_bbbbNS0_7ExtInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang12FunctionTypeC1ENS_4Type9TypeClassENS_8QualTypeES3_bbbbNS0_7ExtInfoE")
  //</editor-fold>
  protected FunctionType(TypeClass tc, QualType res, 
      QualType Canonical, boolean Dependent, 
      boolean InstantiationDependent, 
      boolean VariablyModified, boolean ContainsUnexpandedParameterPack, 
      ExtInfo Info) {
    // : Type(tc, Canonical, Dependent, InstantiationDependent, VariablyModified, ContainsUnexpandedParameterPack), ResultType(res) 
    //START JInit
    super(tc, new QualType(Canonical), Dependent, InstantiationDependent, VariablyModified, 
        ContainsUnexpandedParameterPack);
    this.ResultType = new QualType(res);
    //END JInit
    Unnamed_field.FunctionTypeBits.ExtInfo = $uint2uint_9bits($ushort2uint(Info.Bits));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::getTypeQuals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3006,
   FQN="clang::FunctionType::getTypeQuals", NM="_ZNK5clang12FunctionType12getTypeQualsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType12getTypeQualsEv")
  //</editor-fold>
  protected /*uint*/int getTypeQuals() /*const*/ {
    return Unnamed_field.FunctionTypeBits.TypeQuals;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::getReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3009,
   FQN="clang::FunctionType::getReturnType", NM="_ZNK5clang12FunctionType13getReturnTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType13getReturnTypeEv")
  //</editor-fold>
  public QualType getReturnType() /*const*/ {
    return new QualType(ResultType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::getHasRegParm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3011,
   FQN="clang::FunctionType::getHasRegParm", NM="_ZNK5clang12FunctionType13getHasRegParmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType13getHasRegParmEv")
  //</editor-fold>
  public boolean getHasRegParm() /*const*/ {
    return getExtInfo().getHasRegParm();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::getRegParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3012,
   FQN="clang::FunctionType::getRegParmType", NM="_ZNK5clang12FunctionType14getRegParmTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType14getRegParmTypeEv")
  //</editor-fold>
  public /*uint*/int getRegParmType() /*const*/ {
    return getExtInfo().getRegParm();
  }

  /// Determine whether this function type includes the GNU noreturn
  /// attribute. The C++11 [[noreturn]] attribute does not affect the function
  /// type.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::getNoReturnAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3016,
   FQN="clang::FunctionType::getNoReturnAttr", NM="_ZNK5clang12FunctionType15getNoReturnAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType15getNoReturnAttrEv")
  //</editor-fold>
  public boolean getNoReturnAttr() /*const*/ {
    return getExtInfo().getNoReturn();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::getCallConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3017,
   FQN="clang::FunctionType::getCallConv", NM="_ZNK5clang12FunctionType11getCallConvEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType11getCallConvEv")
  //</editor-fold>
  public CallingConv getCallConv() /*const*/ {
    return getExtInfo().getCC();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::getExtInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3018,
   FQN="clang::FunctionType::getExtInfo", NM="_ZNK5clang12FunctionType10getExtInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType10getExtInfoEv")
  //</editor-fold>
  public ExtInfo getExtInfo() /*const*/ {
    return new ExtInfo(Unnamed_field.FunctionTypeBits.ExtInfo);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::isConst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3019,
   FQN="clang::FunctionType::isConst", NM="_ZNK5clang12FunctionType7isConstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType7isConstEv")
  //</editor-fold>
  public boolean isConst() /*const*/ {
    return ((getTypeQuals() & Qualifiers.TQ.Const) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::isVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3020,
   FQN="clang::FunctionType::isVolatile", NM="_ZNK5clang12FunctionType10isVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType10isVolatileEv")
  //</editor-fold>
  public boolean isVolatile() /*const*/ {
    return ((getTypeQuals() & Qualifiers.TQ.Volatile) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::isRestrict">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3021,
   FQN="clang::FunctionType::isRestrict", NM="_ZNK5clang12FunctionType10isRestrictEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType10isRestrictEv")
  //</editor-fold>
  public boolean isRestrict() /*const*/ {
    return ((getTypeQuals() & Qualifiers.TQ.Restrict) != 0);
  }

  
  /// \brief Determine the type of an expression that calls a function of
  /// this type.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::getCallResultType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3025,
   FQN="clang::FunctionType::getCallResultType", NM="_ZNK5clang12FunctionType17getCallResultTypeERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang12FunctionType17getCallResultTypeERKNS_10ASTContextE")
  //</editor-fold>
  public QualType getCallResultType(final /*const*/ ASTContext /*&*/ Context) /*const*/ {
    return getReturnType().getNonLValueExprType(Context);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::getNameForCallConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2631,
   FQN="clang::FunctionType::getNameForCallConv", NM="_ZN5clang12FunctionType18getNameForCallConvENS_11CallingConvE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang12FunctionType18getNameForCallConvENS_11CallingConvE")
  //</editor-fold>
  public static StringRef getNameForCallConv(CallingConv CC) {
    switch (CC) {
     case CC_C:
      return new StringRef(/*KEEP_STR*/"cdecl");
     case CC_X86StdCall:
      return new StringRef(/*KEEP_STR*/"stdcall");
     case CC_X86FastCall:
      return new StringRef(/*KEEP_STR*/"fastcall");
     case CC_X86ThisCall:
      return new StringRef(/*KEEP_STR*/"thiscall");
     case CC_X86Pascal:
      return new StringRef(/*KEEP_STR*/"pascal");
     case CC_X86VectorCall:
      return new StringRef(/*KEEP_STR*/"vectorcall");
     case CC_X86_64Win64:
      return new StringRef(/*KEEP_STR*/"ms_abi");
     case CC_X86_64SysV:
      return new StringRef(/*KEEP_STR*/"sysv_abi");
     case CC_AAPCS:
      return new StringRef(/*KEEP_STR*/"aapcs");
     case CC_AAPCS_VFP:
      return new StringRef(/*KEEP_STR*/"aapcs-vfp");
     case CC_IntelOclBicc:
      return new StringRef(/*KEEP_STR*/"intel_ocl_bicc");
     case CC_SpirFunction:
      return new StringRef(/*KEEP_STR*/"spir_function");
     case CC_OpenCLKernel:
      return new StringRef(/*KEEP_STR*/"opencl_kernel");
     case CC_Swift:
      return new StringRef(/*KEEP_STR*/"swiftcall");
     case CC_PreserveMost:
      return new StringRef(/*KEEP_STR*/"preserve_most");
     case CC_PreserveAll:
      return new StringRef(/*KEEP_STR*/"preserve_all");
    }
    throw new llvm_unreachable("Invalid calling convention.");
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3031,
   FQN="clang::FunctionType::classof", NM="_ZN5clang12FunctionType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang12FunctionType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.FunctionNoProto
       || T.getTypeClass() == TypeClass.FunctionProto;
  }

  @Override public String toString() {
    return "" + "ResultType=" + ResultType // NOI18N
              + super.toString(); // NOI18N
  }
}

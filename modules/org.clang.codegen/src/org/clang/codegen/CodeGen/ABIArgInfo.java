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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.llvm.ir.Type;
import static org.llvm.ir.java.IrRTTI.*;


/// ABIArgInfo - Helper class to encapsulate information about how a
/// specific C type should be passed to or returned from a function.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 34,
 FQN="clang::CodeGen::ABIArgInfo", NM="_ZN5clang7CodeGen10ABIArgInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfoE")
//</editor-fold>
public class ABIArgInfo {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::Kind">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 36,
   FQN="clang::CodeGen::ABIArgInfo::Kind", NM="_ZN5clang7CodeGen10ABIArgInfo4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo4KindE")
  //</editor-fold>
  public enum Kind/* : uint8_t*/ implements Native.NativeUCharEnum {
    /// Direct - Pass the argument directly using the normal converted LLVM
    /// type, or by coercing to another specified type stored in
    /// 'CoerceToType').  If an offset is specified (in UIntData), then the
    /// argument passed is offset by some number of bytes in the memory
    /// representation. A dummy argument is emitted before the real argument
    /// if the specified type stored in "PaddingType" is not zero.
    Direct(0),
    
    /// Extend - Valid only for integer argument types. Same as 'direct'
    /// but also emit a zero/sign extension attribute.
    Extend(Direct.getValue() + 1),
    
    /// Indirect - Pass the argument indirectly via a hidden pointer
    /// with the specified alignment (0 indicates default alignment).
    Indirect(Extend.getValue() + 1),
    
    /// Ignore - Ignore the argument (treat as void). Useful for void and
    /// empty structs.
    Ignore(Indirect.getValue() + 1),
    
    /// Expand - Only valid for aggregate argument types. The structure should
    /// be expanded into consecutive arguments for its constituent fields.
    /// Currently expand is only allowed on structures whose fields
    /// are all scalar types or are themselves expandable types.
    Expand(Ignore.getValue() + 1),
    
    /// CoerceAndExpand - Only valid for aggregate argument types. The
    /// structure should be expanded into consecutive arguments corresponding
    /// to the non-array elements of the type stored in CoerceToType.
    /// Array elements in the type are assumed to be padding and skipped.
    CoerceAndExpand(Expand.getValue() + 1),
    
    /// InAlloca - Pass the argument directly using the LLVM inalloca attribute.
    /// This is similar to indirect with byval, except it only applies to
    /// arguments stored in memory and forbids any implicit copies.  When
    /// applied to a return type, it means the value is returned indirectly via
    /// an implicit sret parameter stored in the argument struct.
    InAlloca(CoerceAndExpand.getValue() + 1),
    KindFirst(Kind.Direct.getValue()),
    KindLast(Kind.InAlloca.getValue());

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(byte/*uint8_t*/ val) {
      Kind out = valueOf((int)val);
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
      return out;
    }
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
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

    private final byte/*uint8_t*/ value;
    private Kind(int val) { this.value = (byte/*uint8_t*/)val;}
    @Override public final byte/*uint8_t*/ getValue() { return value;}
    //</editor-fold>
  };
/*private:*/
  private Type /*P*/ TypeData; // canHaveCoerceToType()
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 81,
   FQN="clang::CodeGen::ABIArgInfo::(anonymous)", NM="_ZN5clang7CodeGen10ABIArgInfoE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfoE_Unnamed_union1")
  //</editor-fold>
  private static class/*union*/ Unnamed_union1 {
    public Type /*P*/ PaddingType; // canHavePaddingType()
    public Type /*P*/ UnpaddedCoerceAndExpandType; // isCoerceAndExpand()
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 81,
     FQN="clang::CodeGen::ABIArgInfo::(anonymous union)::", NM="_ZN5clang7CodeGen10ABIArgInfoUt_C1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfoUt_C1EOS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(JD$Move _dparam, final Unnamed_union1 $Prm0) {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 81,
     FQN="clang::CodeGen::ABIArgInfo::(anonymous union)::operator=", NM="_ZN5clang7CodeGen10ABIArgInfoUt_aSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfoUt_aSEOS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1 $assignMove(final Unnamed_union1 $Prm0) {
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    private Unnamed_union1() {}

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "PaddingType=" + PaddingType // NOI18N
                + ", UnpaddedCoerceAndExpandType=" + UnpaddedCoerceAndExpandType; // NOI18N
    }
  };
  private Unnamed_union1 Unnamed_field1 = new Unnamed_union1();
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 85,
   FQN="clang::CodeGen::ABIArgInfo::(anonymous)", NM="_ZN5clang7CodeGen10ABIArgInfoE_Unnamed_union2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfoE_Unnamed_union2")
  //</editor-fold>
  private static class/*union*/ Unnamed_union2 {
    public /*uint*/int DirectOffset; // isDirect() || isExtend()
    public /*uint*/int IndirectAlign; // isIndirect()
    public /*uint*/int AllocaFieldIndex; // isInAlloca()
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 85,
     FQN="clang::CodeGen::ABIArgInfo::(anonymous union)::", NM="_ZN5clang7CodeGen10ABIArgInfoUt0_C1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfoUt0_C1EOS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union2(JD$Move _dparam, final Unnamed_union2 $Prm0) {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 85,
     FQN="clang::CodeGen::ABIArgInfo::(anonymous union)::operator=", NM="_ZN5clang7CodeGen10ABIArgInfoUt0_aSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfoUt0_aSEOS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union2 $assignMove(final Unnamed_union2 $Prm0) {
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    private Unnamed_union2() {}

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "DirectOffset=" + DirectOffset // NOI18N
                + ", IndirectAlign=" + IndirectAlign // NOI18N
                + ", AllocaFieldIndex=" + AllocaFieldIndex; // NOI18N
    }
  };
  private Unnamed_union2 Unnamed_field2 = new Unnamed_union2();
  private Kind TheKind;
  private /*JBIT bool*/ boolean PaddingInReg /*: 1*/;
  private /*JBIT bool*/ boolean InAllocaSRet /*: 1*/; // isInAlloca()
  private /*JBIT bool*/ boolean IndirectByVal /*: 1*/; // isIndirect()
  private /*JBIT bool*/ boolean IndirectRealign /*: 1*/; // isIndirect()
  private /*JBIT bool*/ boolean SRetAfterThis /*: 1*/; // isIndirect()
  private /*JBIT bool*/ boolean InReg /*: 1*/; // isDirect() || isExtend() || isIndirect()
  private /*JBIT bool*/ boolean CanBeFlattened /*: 1*/; // isDirect()
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::canHavePaddingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 99,
   FQN="clang::CodeGen::ABIArgInfo::canHavePaddingType", NM="_ZNK5clang7CodeGen10ABIArgInfo18canHavePaddingTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo18canHavePaddingTypeEv")
  //</editor-fold>
  private boolean canHavePaddingType() /*const*/ {
    return isDirect() || isExtend() || isIndirect() || isExpand();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::setPaddingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 102,
   FQN="clang::CodeGen::ABIArgInfo::setPaddingType", NM="_ZN5clang7CodeGen10ABIArgInfo14setPaddingTypeEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo14setPaddingTypeEPN4llvm4TypeE")
  //</editor-fold>
  private void setPaddingType(Type /*P*/ T) {
    assert (canHavePaddingType());
    Unnamed_field1.PaddingType = T;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::setUnpaddedCoerceToType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 107,
   FQN="clang::CodeGen::ABIArgInfo::setUnpaddedCoerceToType", NM="_ZN5clang7CodeGen10ABIArgInfo23setUnpaddedCoerceToTypeEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo23setUnpaddedCoerceToTypeEPN4llvm4TypeE")
  //</editor-fold>
  private void setUnpaddedCoerceToType(Type /*P*/ T) {
    assert (isCoerceAndExpand());
    Unnamed_field1.UnpaddedCoerceAndExpandType = T;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::ABIArgInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 112,
   FQN="clang::CodeGen::ABIArgInfo::ABIArgInfo", NM="_ZN5clang7CodeGen10ABIArgInfoC1ENS1_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfoC1ENS1_4KindE")
  //</editor-fold>
  private ABIArgInfo(Kind K) {
    // : TheKind(K), PaddingInReg(false), InReg(false) 
    //START JInit
    this.TheKind = K;
    this.PaddingInReg = false;
    this.InReg = false;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::ABIArgInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 117,
   FQN="clang::CodeGen::ABIArgInfo::ABIArgInfo", NM="_ZN5clang7CodeGen10ABIArgInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfoC1Ev")
  //</editor-fold>
  public ABIArgInfo() {
    // : TypeData(null), PaddingType(null), DirectOffset(0), TheKind(Direct), PaddingInReg(false), InReg(false) 
    //START JInit
    this.TypeData = null;
    /*Indirect*/this.Unnamed_field1.PaddingType = null;
    /*Indirect*/this.Unnamed_field2.DirectOffset = 0;
    this.TheKind = Kind.Direct;
    this.PaddingInReg = false;
    this.InReg = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getDirect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 121,
   FQN="clang::CodeGen::ABIArgInfo::getDirect", NM="_ZN5clang7CodeGen10ABIArgInfo9getDirectEPN4llvm4TypeEjS4_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo9getDirectEPN4llvm4TypeEjS4_b")
  //</editor-fold>
  public static ABIArgInfo getDirect() {
    return getDirect((Type /*P*/ )null, 0, 
           (Type /*P*/ )null, 
           true);
  }
  public static ABIArgInfo getDirect(Type /*P*/ T/*= null*/) {
    return getDirect(T, 0, 
           (Type /*P*/ )null, 
           true);
  }
  public static ABIArgInfo getDirect(Type /*P*/ T/*= null*/, /*uint*/int Offset/*= 0*/) {
    return getDirect(T, Offset, 
           (Type /*P*/ )null, 
           true);
  }
  public static ABIArgInfo getDirect(Type /*P*/ T/*= null*/, /*uint*/int Offset/*= 0*/, 
           Type /*P*/ Padding/*= null*/) {
    return getDirect(T, Offset, 
           Padding, 
           true);
  }
  public static ABIArgInfo getDirect(Type /*P*/ T/*= null*/, /*uint*/int Offset/*= 0*/, 
           Type /*P*/ Padding/*= null*/, 
           boolean CanBeFlattened/*= true*/) {
    ABIArgInfo AI = new ABIArgInfo(Kind.Direct);
    AI.setCoerceToType(T);
    AI.setPaddingType(Padding);
    AI.setDirectOffset(Offset);
    AI.setCanBeFlattened(CanBeFlattened);
    return AI;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getDirectInReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 131,
   FQN="clang::CodeGen::ABIArgInfo::getDirectInReg", NM="_ZN5clang7CodeGen10ABIArgInfo14getDirectInRegEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo14getDirectInRegEPN4llvm4TypeE")
  //</editor-fold>
  public static ABIArgInfo getDirectInReg() {
    return getDirectInReg((Type /*P*/ )null);
  }
  public static ABIArgInfo getDirectInReg(Type /*P*/ T/*= null*/) {
    ABIArgInfo AI = ABIArgInfo.getDirect(T);
    AI.setInReg(true);
    return AI;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getExtend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 136,
   FQN="clang::CodeGen::ABIArgInfo::getExtend", NM="_ZN5clang7CodeGen10ABIArgInfo9getExtendEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo9getExtendEPN4llvm4TypeE")
  //</editor-fold>
  public static ABIArgInfo getExtend() {
    return getExtend((Type /*P*/ )null);
  }
  public static ABIArgInfo getExtend(Type /*P*/ T/*= null*/) {
    ABIArgInfo AI = new ABIArgInfo(Kind.Extend);
    AI.setCoerceToType(T);
    AI.setPaddingType((Type /*P*/ )null);
    AI.setDirectOffset(0);
    return AI;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getExtendInReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 143,
   FQN="clang::CodeGen::ABIArgInfo::getExtendInReg", NM="_ZN5clang7CodeGen10ABIArgInfo14getExtendInRegEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo14getExtendInRegEPN4llvm4TypeE")
  //</editor-fold>
  public static ABIArgInfo getExtendInReg() {
    return getExtendInReg((Type /*P*/ )null);
  }
  public static ABIArgInfo getExtendInReg(Type /*P*/ T/*= null*/) {
    ABIArgInfo AI = ABIArgInfo.getExtend(T);
    AI.setInReg(true);
    return AI;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getIgnore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 148,
   FQN="clang::CodeGen::ABIArgInfo::getIgnore", NM="_ZN5clang7CodeGen10ABIArgInfo9getIgnoreEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo9getIgnoreEv")
  //</editor-fold>
  public static ABIArgInfo getIgnore() {
    return new ABIArgInfo(Kind.Ignore);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getIndirect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 151,
   FQN="clang::CodeGen::ABIArgInfo::getIndirect", NM="_ZN5clang7CodeGen10ABIArgInfo11getIndirectENS_9CharUnitsEbbPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo11getIndirectENS_9CharUnitsEbbPN4llvm4TypeE")
  //</editor-fold>
  public static ABIArgInfo getIndirect(CharUnits Alignment) {
    return getIndirect(Alignment, true, 
             false, 
             (Type /*P*/ )null);
  }
  public static ABIArgInfo getIndirect(CharUnits Alignment, boolean ByVal/*= true*/) {
    return getIndirect(Alignment, ByVal, 
             false, 
             (Type /*P*/ )null);
  }
  public static ABIArgInfo getIndirect(CharUnits Alignment, boolean ByVal/*= true*/, 
             boolean Realign/*= false*/) {
    return getIndirect(Alignment, ByVal, 
             Realign, 
             (Type /*P*/ )null);
  }
  public static ABIArgInfo getIndirect(CharUnits Alignment, boolean ByVal/*= true*/, 
             boolean Realign/*= false*/, 
             Type /*P*/ Padding/*= null*/) {
    ABIArgInfo AI = new ABIArgInfo(Kind.Indirect);
    AI.setIndirectAlign(new CharUnits(Alignment));
    AI.setIndirectByVal(ByVal);
    AI.setIndirectRealign(Realign);
    AI.setSRetAfterThis(false);
    AI.setPaddingType(Padding);
    return AI;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getIndirectInReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 162,
   FQN="clang::CodeGen::ABIArgInfo::getIndirectInReg", NM="_ZN5clang7CodeGen10ABIArgInfo16getIndirectInRegENS_9CharUnitsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo16getIndirectInRegENS_9CharUnitsEbb")
  //</editor-fold>
  public static ABIArgInfo getIndirectInReg(CharUnits Alignment) {
    return getIndirectInReg(Alignment, true, 
                  false);
  }
  public static ABIArgInfo getIndirectInReg(CharUnits Alignment, boolean ByVal/*= true*/) {
    return getIndirectInReg(Alignment, ByVal, 
                  false);
  }
  public static ABIArgInfo getIndirectInReg(CharUnits Alignment, boolean ByVal/*= true*/, 
                  boolean Realign/*= false*/) {
    ABIArgInfo AI = ABIArgInfo.getIndirect(new CharUnits(Alignment), ByVal, Realign);
    AI.setInReg(true);
    return AI;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getInAlloca">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 168,
   FQN="clang::CodeGen::ABIArgInfo::getInAlloca", NM="_ZN5clang7CodeGen10ABIArgInfo11getInAllocaEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo11getInAllocaEj")
  //</editor-fold>
  public static ABIArgInfo getInAlloca(/*uint*/int FieldIndex) {
    ABIArgInfo AI = new ABIArgInfo(Kind.InAlloca);
    AI.setInAllocaFieldIndex(FieldIndex);
    return AI;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getExpand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 173,
   FQN="clang::CodeGen::ABIArgInfo::getExpand", NM="_ZN5clang7CodeGen10ABIArgInfo9getExpandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo9getExpandEv")
  //</editor-fold>
  public static ABIArgInfo getExpand() {
    ABIArgInfo AI = new ABIArgInfo(Kind.Expand);
    AI.setPaddingType((Type /*P*/ )null);
    return AI;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getExpandWithPadding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 178,
   FQN="clang::CodeGen::ABIArgInfo::getExpandWithPadding", NM="_ZN5clang7CodeGen10ABIArgInfo20getExpandWithPaddingEbPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo20getExpandWithPaddingEbPN4llvm4TypeE")
  //</editor-fold>
  public static ABIArgInfo getExpandWithPadding(boolean PaddingInReg, 
                      Type /*P*/ Padding) {
    ABIArgInfo AI = ABIArgInfo.getExpand();
    AI.setPaddingInReg(PaddingInReg);
    AI.setPaddingType(Padding);
    return AI;
  }

  
  /// \param unpaddedCoerceToType The coerce-to type with padding elements
  ///   removed, canonicalized to a single element if it would otherwise
  ///   have exactly one element.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getCoerceAndExpand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 189,
   FQN="clang::CodeGen::ABIArgInfo::getCoerceAndExpand", NM="_ZN5clang7CodeGen10ABIArgInfo18getCoerceAndExpandEPN4llvm10StructTypeEPNS2_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo18getCoerceAndExpandEPN4llvm10StructTypeEPNS2_4TypeE")
  //</editor-fold>
  public static ABIArgInfo getCoerceAndExpand(StructType /*P*/ coerceToType, 
                    Type /*P*/ unpaddedCoerceToType) {
    // Sanity checks on unpaddedCoerceToType.
    
    // Assert that we only have a struct type if there are multiple elements.
    StructType /*P*/ unpaddedStruct = dyn_cast_StructType(unpaddedCoerceToType);
    assert (!(unpaddedStruct != null) || unpaddedStruct.getNumElements() != 1);
    
    // Assert that all the non-padding elements have a corresponding element
    // in the unpadded type.
    /*uint*/int unpaddedIndex = 0;
    for (Type /*P*/ eltType : coerceToType.elements()) {
      if (ABIArgInfo.isPaddingForCoerceAndExpand(eltType)) {
        continue;
      }
      if ((unpaddedStruct != null)) {
        assert (unpaddedStruct.getElementType(unpaddedIndex) == eltType);
      } else {
        assert (unpaddedIndex == 0 && unpaddedCoerceToType == eltType);
      }
      unpaddedIndex++;
    }
    
    // Assert that there aren't extra elements in the unpadded type.
    if ((unpaddedStruct != null)) {
      assert (unpaddedStruct.getNumElements() == unpaddedIndex);
    } else {
      assert (unpaddedIndex == 1);
    }
    
    ABIArgInfo AI = new ABIArgInfo(Kind.CoerceAndExpand);
    AI.setCoerceToType(coerceToType);
    AI.setUnpaddedCoerceToType(unpaddedCoerceToType);
    return AI;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::isPaddingForCoerceAndExpand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 225,
   FQN="clang::CodeGen::ABIArgInfo::isPaddingForCoerceAndExpand", NM="_ZN5clang7CodeGen10ABIArgInfo27isPaddingForCoerceAndExpandEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo27isPaddingForCoerceAndExpandEPN4llvm4TypeE")
  //</editor-fold>
  public static boolean isPaddingForCoerceAndExpand(Type /*P*/ eltType) {
    if (eltType.isArrayTy()) {
      assert (eltType.getArrayElementType().isIntegerTy(8));
      return true;
    } else {
      return false;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 234,
   FQN="clang::CodeGen::ABIArgInfo::getKind", NM="_ZNK5clang7CodeGen10ABIArgInfo7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    return TheKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::isDirect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 235,
   FQN="clang::CodeGen::ABIArgInfo::isDirect", NM="_ZNK5clang7CodeGen10ABIArgInfo8isDirectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo8isDirectEv")
  //</editor-fold>
  public boolean isDirect() /*const*/ {
    return TheKind == Kind.Direct;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::isInAlloca">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 236,
   FQN="clang::CodeGen::ABIArgInfo::isInAlloca", NM="_ZNK5clang7CodeGen10ABIArgInfo10isInAllocaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo10isInAllocaEv")
  //</editor-fold>
  public boolean isInAlloca() /*const*/ {
    return TheKind == Kind.InAlloca;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::isExtend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 237,
   FQN="clang::CodeGen::ABIArgInfo::isExtend", NM="_ZNK5clang7CodeGen10ABIArgInfo8isExtendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo8isExtendEv")
  //</editor-fold>
  public boolean isExtend() /*const*/ {
    return TheKind == Kind.Extend;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::isIgnore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 238,
   FQN="clang::CodeGen::ABIArgInfo::isIgnore", NM="_ZNK5clang7CodeGen10ABIArgInfo8isIgnoreEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo8isIgnoreEv")
  //</editor-fold>
  public boolean isIgnore() /*const*/ {
    return TheKind == Kind.Ignore;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::isIndirect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 239,
   FQN="clang::CodeGen::ABIArgInfo::isIndirect", NM="_ZNK5clang7CodeGen10ABIArgInfo10isIndirectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo10isIndirectEv")
  //</editor-fold>
  public boolean isIndirect() /*const*/ {
    return TheKind == Kind.Indirect;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::isExpand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 240,
   FQN="clang::CodeGen::ABIArgInfo::isExpand", NM="_ZNK5clang7CodeGen10ABIArgInfo8isExpandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo8isExpandEv")
  //</editor-fold>
  public boolean isExpand() /*const*/ {
    return TheKind == Kind.Expand;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::isCoerceAndExpand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 241,
   FQN="clang::CodeGen::ABIArgInfo::isCoerceAndExpand", NM="_ZNK5clang7CodeGen10ABIArgInfo17isCoerceAndExpandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo17isCoerceAndExpandEv")
  //</editor-fold>
  public boolean isCoerceAndExpand() /*const*/ {
    return TheKind == Kind.CoerceAndExpand;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::canHaveCoerceToType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 243,
   FQN="clang::CodeGen::ABIArgInfo::canHaveCoerceToType", NM="_ZNK5clang7CodeGen10ABIArgInfo19canHaveCoerceToTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo19canHaveCoerceToTypeEv")
  //</editor-fold>
  public boolean canHaveCoerceToType() /*const*/ {
    return isDirect() || isExtend() || isCoerceAndExpand();
  }

  
  // Direct/Extend accessors
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getDirectOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 248,
   FQN="clang::CodeGen::ABIArgInfo::getDirectOffset", NM="_ZNK5clang7CodeGen10ABIArgInfo15getDirectOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo15getDirectOffsetEv")
  //</editor-fold>
  public /*uint*/int getDirectOffset() /*const*/ {
    assert ((isDirect() || isExtend())) : "Not a direct or extend kind";
    return Unnamed_field2.DirectOffset;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::setDirectOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 252,
   FQN="clang::CodeGen::ABIArgInfo::setDirectOffset", NM="_ZN5clang7CodeGen10ABIArgInfo15setDirectOffsetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo15setDirectOffsetEj")
  //</editor-fold>
  public void setDirectOffset(/*uint*/int Offset) {
    assert ((isDirect() || isExtend())) : "Not a direct or extend kind";
    Unnamed_field2.DirectOffset = Offset;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getPaddingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 257,
   FQN="clang::CodeGen::ABIArgInfo::getPaddingType", NM="_ZNK5clang7CodeGen10ABIArgInfo14getPaddingTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo14getPaddingTypeEv")
  //</editor-fold>
  public Type /*P*/ getPaddingType() /*const*/ {
    return (canHavePaddingType() ? Unnamed_field1.PaddingType : null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getPaddingInReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 261,
   FQN="clang::CodeGen::ABIArgInfo::getPaddingInReg", NM="_ZNK5clang7CodeGen10ABIArgInfo15getPaddingInRegEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo15getPaddingInRegEv")
  //</editor-fold>
  public boolean getPaddingInReg() /*const*/ {
    return PaddingInReg;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::setPaddingInReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 264,
   FQN="clang::CodeGen::ABIArgInfo::setPaddingInReg", NM="_ZN5clang7CodeGen10ABIArgInfo15setPaddingInRegEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo15setPaddingInRegEb")
  //</editor-fold>
  public void setPaddingInReg(boolean PIR) {
    PaddingInReg = PIR;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getCoerceToType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 268,
   FQN="clang::CodeGen::ABIArgInfo::getCoerceToType", NM="_ZNK5clang7CodeGen10ABIArgInfo15getCoerceToTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo15getCoerceToTypeEv")
  //</editor-fold>
  public Type /*P*/ getCoerceToType() /*const*/ {
    assert (canHaveCoerceToType()) : "Invalid kind!";
    return TypeData;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::setCoerceToType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 273,
   FQN="clang::CodeGen::ABIArgInfo::setCoerceToType", NM="_ZN5clang7CodeGen10ABIArgInfo15setCoerceToTypeEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo15setCoerceToTypeEPN4llvm4TypeE")
  //</editor-fold>
  public void setCoerceToType(Type /*P*/ T) {
    assert (canHaveCoerceToType()) : "Invalid kind!";
    TypeData = T;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getCoerceAndExpandType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 278,
   FQN="clang::CodeGen::ABIArgInfo::getCoerceAndExpandType", NM="_ZNK5clang7CodeGen10ABIArgInfo22getCoerceAndExpandTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo22getCoerceAndExpandTypeEv")
  //</editor-fold>
  public StructType /*P*/ getCoerceAndExpandType() /*const*/ {
    assert (isCoerceAndExpand());
    return cast_StructType(TypeData);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getUnpaddedCoerceAndExpandType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 283,
   FQN="clang::CodeGen::ABIArgInfo::getUnpaddedCoerceAndExpandType", NM="_ZNK5clang7CodeGen10ABIArgInfo30getUnpaddedCoerceAndExpandTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo30getUnpaddedCoerceAndExpandTypeEv")
  //</editor-fold>
  public Type /*P*/ getUnpaddedCoerceAndExpandType() /*const*/ {
    assert (isCoerceAndExpand());
    return Unnamed_field1.UnpaddedCoerceAndExpandType;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getCoerceAndExpandTypeSequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 288,
   FQN="clang::CodeGen::ABIArgInfo::getCoerceAndExpandTypeSequence", NM="_ZNK5clang7CodeGen10ABIArgInfo30getCoerceAndExpandTypeSequenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo30getCoerceAndExpandTypeSequenceEv")
  //</editor-fold>
  public ArrayRef<Type /*P*/ > getCoerceAndExpandTypeSequence() /*const*/ {
    assert (isCoerceAndExpand());
    {
      StructType /*P*/ structTy = dyn_cast_StructType(Unnamed_field1.UnpaddedCoerceAndExpandType);
      if ((structTy != null)) {
        return structTy.elements();
      } else {
        return llvm.makeArrayRef(/*AddrOf*/create_type$ptr2ConstT(Unnamed_field1.UnpaddedCoerceAndExpandType), 1);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getInReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 298,
   FQN="clang::CodeGen::ABIArgInfo::getInReg", NM="_ZNK5clang7CodeGen10ABIArgInfo8getInRegEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo8getInRegEv")
  //</editor-fold>
  public boolean getInReg() /*const*/ {
    assert ((isDirect() || isExtend() || isIndirect())) : "Invalid kind!";
    return InReg;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::setInReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 303,
   FQN="clang::CodeGen::ABIArgInfo::setInReg", NM="_ZN5clang7CodeGen10ABIArgInfo8setInRegEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo8setInRegEb")
  //</editor-fold>
  public void setInReg(boolean IR) {
    assert ((isDirect() || isExtend() || isIndirect())) : "Invalid kind!";
    InReg = IR;
  }

  
  // Indirect accessors
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getIndirectAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 309,
   FQN="clang::CodeGen::ABIArgInfo::getIndirectAlign", NM="_ZNK5clang7CodeGen10ABIArgInfo16getIndirectAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo16getIndirectAlignEv")
  //</editor-fold>
  public CharUnits getIndirectAlign() /*const*/ {
    assert (isIndirect()) : "Invalid kind!";
    return CharUnits.fromQuantity($uint2long(Unnamed_field2.IndirectAlign));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::setIndirectAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 313,
   FQN="clang::CodeGen::ABIArgInfo::setIndirectAlign", NM="_ZN5clang7CodeGen10ABIArgInfo16setIndirectAlignENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo16setIndirectAlignENS_9CharUnitsE")
  //</editor-fold>
  public void setIndirectAlign(CharUnits IA) {
    assert (isIndirect()) : "Invalid kind!";
    Unnamed_field2.IndirectAlign = $long2uint(IA.getQuantity());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getIndirectByVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 318,
   FQN="clang::CodeGen::ABIArgInfo::getIndirectByVal", NM="_ZNK5clang7CodeGen10ABIArgInfo16getIndirectByValEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo16getIndirectByValEv")
  //</editor-fold>
  public boolean getIndirectByVal() /*const*/ {
    assert (isIndirect()) : "Invalid kind!";
    return IndirectByVal;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::setIndirectByVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 322,
   FQN="clang::CodeGen::ABIArgInfo::setIndirectByVal", NM="_ZN5clang7CodeGen10ABIArgInfo16setIndirectByValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo16setIndirectByValEb")
  //</editor-fold>
  public void setIndirectByVal(boolean IBV) {
    assert (isIndirect()) : "Invalid kind!";
    IndirectByVal = IBV;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getIndirectRealign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 327,
   FQN="clang::CodeGen::ABIArgInfo::getIndirectRealign", NM="_ZNK5clang7CodeGen10ABIArgInfo18getIndirectRealignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo18getIndirectRealignEv")
  //</editor-fold>
  public boolean getIndirectRealign() /*const*/ {
    assert (isIndirect()) : "Invalid kind!";
    return IndirectRealign;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::setIndirectRealign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 331,
   FQN="clang::CodeGen::ABIArgInfo::setIndirectRealign", NM="_ZN5clang7CodeGen10ABIArgInfo18setIndirectRealignEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo18setIndirectRealignEb")
  //</editor-fold>
  public void setIndirectRealign(boolean IR) {
    assert (isIndirect()) : "Invalid kind!";
    IndirectRealign = IR;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::isSRetAfterThis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 336,
   FQN="clang::CodeGen::ABIArgInfo::isSRetAfterThis", NM="_ZNK5clang7CodeGen10ABIArgInfo15isSRetAfterThisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo15isSRetAfterThisEv")
  //</editor-fold>
  public boolean isSRetAfterThis() /*const*/ {
    assert (isIndirect()) : "Invalid kind!";
    return SRetAfterThis;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::setSRetAfterThis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 340,
   FQN="clang::CodeGen::ABIArgInfo::setSRetAfterThis", NM="_ZN5clang7CodeGen10ABIArgInfo16setSRetAfterThisEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo16setSRetAfterThisEb")
  //</editor-fold>
  public void setSRetAfterThis(boolean AfterThis) {
    assert (isIndirect()) : "Invalid kind!";
    SRetAfterThis = AfterThis;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getInAllocaFieldIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 345,
   FQN="clang::CodeGen::ABIArgInfo::getInAllocaFieldIndex", NM="_ZNK5clang7CodeGen10ABIArgInfo21getInAllocaFieldIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo21getInAllocaFieldIndexEv")
  //</editor-fold>
  public /*uint*/int getInAllocaFieldIndex() /*const*/ {
    assert (isInAlloca()) : "Invalid kind!";
    return Unnamed_field2.AllocaFieldIndex;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::setInAllocaFieldIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 349,
   FQN="clang::CodeGen::ABIArgInfo::setInAllocaFieldIndex", NM="_ZN5clang7CodeGen10ABIArgInfo21setInAllocaFieldIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo21setInAllocaFieldIndexEj")
  //</editor-fold>
  public void setInAllocaFieldIndex(/*uint*/int FieldIndex) {
    assert (isInAlloca()) : "Invalid kind!";
    Unnamed_field2.AllocaFieldIndex = FieldIndex;
  }

  
  /// \brief Return true if this field of an inalloca struct should be returned
  /// to implement a struct return calling convention.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getInAllocaSRet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 356,
   FQN="clang::CodeGen::ABIArgInfo::getInAllocaSRet", NM="_ZNK5clang7CodeGen10ABIArgInfo15getInAllocaSRetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo15getInAllocaSRetEv")
  //</editor-fold>
  public boolean getInAllocaSRet() /*const*/ {
    assert (isInAlloca()) : "Invalid kind!";
    return InAllocaSRet;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::setInAllocaSRet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 361,
   FQN="clang::CodeGen::ABIArgInfo::setInAllocaSRet", NM="_ZN5clang7CodeGen10ABIArgInfo15setInAllocaSRetEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo15setInAllocaSRetEb")
  //</editor-fold>
  public void setInAllocaSRet(boolean SRet) {
    assert (isInAlloca()) : "Invalid kind!";
    InAllocaSRet = SRet;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::getCanBeFlattened">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 366,
   FQN="clang::CodeGen::ABIArgInfo::getCanBeFlattened", NM="_ZNK5clang7CodeGen10ABIArgInfo17getCanBeFlattenedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo17getCanBeFlattenedEv")
  //</editor-fold>
  public boolean getCanBeFlattened() /*const*/ {
    assert (isDirect()) : "Invalid kind!";
    return CanBeFlattened;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::setCanBeFlattened">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 371,
   FQN="clang::CodeGen::ABIArgInfo::setCanBeFlattened", NM="_ZN5clang7CodeGen10ABIArgInfo17setCanBeFlattenedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfo17setCanBeFlattenedEb")
  //</editor-fold>
  public void setCanBeFlattened(boolean Flatten) {
    assert (isDirect()) : "Invalid kind!";
    CanBeFlattened = Flatten;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 176,
   FQN="clang::CodeGen::ABIArgInfo::dump", NM="_ZNK5clang7CodeGen10ABIArgInfo4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen10ABIArgInfo4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    final raw_ostream /*&*/ OS = llvm.errs();
    OS.$out(/*KEEP_STR*/"(ABIArgInfo Kind=");
    switch (TheKind) {
     case Direct:
      OS.$out(/*KEEP_STR*/"Direct Type=");
      {
        Type /*P*/ Ty = getCoerceToType();
        if ((Ty != null)) {
          Ty.print(OS);
        } else {
          OS.$out(/*KEEP_STR*/"null");
        }
      }
      break;
     case Extend:
      OS.$out(/*KEEP_STR*/"Extend");
      break;
     case Ignore:
      OS.$out(/*KEEP_STR*/"Ignore");
      break;
     case InAlloca:
      OS.$out(/*KEEP_STR*/"InAlloca Offset=").$out_uint(getInAllocaFieldIndex());
      break;
     case Indirect:
      OS.$out(/*KEEP_STR*/"Indirect Align=").$out_llong(getIndirectAlign().getQuantity()).$out(
          /*KEEP_STR*/" ByVal="
      ).$out_int((getIndirectByVal() ? 1 : 0)).$out(
          /*KEEP_STR*/" Realign="
      ).$out_int((getIndirectRealign() ? 1 : 0));
      break;
     case Expand:
      OS.$out(/*KEEP_STR*/"Expand");
      break;
     case CoerceAndExpand:
      OS.$out(/*KEEP_STR*/"CoerceAndExpand Type=");
      getCoerceAndExpandType().print(OS);
      break;
    }
    OS.$out(/*KEEP_STR*/")\n");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::ABIArgInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 34,
   FQN="clang::CodeGen::ABIArgInfo::ABIArgInfo", NM="_ZN5clang7CodeGen10ABIArgInfoC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfoC1EOS1_")
  //</editor-fold>
  public /*inline*/ ABIArgInfo(JD$Move _dparam, final ABIArgInfo /*&&*/$Prm0) {
    // : TypeData(static_cast<ABIArgInfo &&>().TypeData), Unnamed_field1(static_cast<ABIArgInfo &&>().), Unnamed_field2(static_cast<ABIArgInfo &&>().), TheKind(static_cast<ABIArgInfo &&>().TheKind), PaddingInReg(static_cast<ABIArgInfo &&>().PaddingInReg), InAllocaSRet(static_cast<ABIArgInfo &&>().InAllocaSRet), IndirectByVal(static_cast<ABIArgInfo &&>().IndirectByVal), IndirectRealign(static_cast<ABIArgInfo &&>().IndirectRealign), SRetAfterThis(static_cast<ABIArgInfo &&>().SRetAfterThis), InReg(static_cast<ABIArgInfo &&>().InReg), CanBeFlattened(static_cast<ABIArgInfo &&>().CanBeFlattened) 
    //START JInit
    this.TypeData = $Prm0.TypeData;
    this.Unnamed_field1 = new Unnamed_union1(JD$Move.INSTANCE, $Prm0.Unnamed_field1);
    this.Unnamed_field2 = new Unnamed_union2(JD$Move.INSTANCE, $Prm0.Unnamed_field2);
    this.TheKind = $Prm0.TheKind;
    this.PaddingInReg = $Prm0.PaddingInReg;
    this.InAllocaSRet = $Prm0.InAllocaSRet;
    this.IndirectByVal = $Prm0.IndirectByVal;
    this.IndirectRealign = $Prm0.IndirectRealign;
    this.SRetAfterThis = $Prm0.SRetAfterThis;
    this.InReg = $Prm0.InReg;
    this.CanBeFlattened = $Prm0.CanBeFlattened;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIArgInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 34,
   FQN="clang::CodeGen::ABIArgInfo::operator=", NM="_ZN5clang7CodeGen10ABIArgInfoaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen10ABIArgInfoaSEOS1_")
  //</editor-fold>
  public /*inline*/ ABIArgInfo /*&*/ $assignMove(final ABIArgInfo /*&&*/$Prm0) {
    this.TypeData = $Prm0.TypeData;
    this.Unnamed_field1.$assignMove($Prm0.Unnamed_field1);
    this.Unnamed_field2.$assignMove($Prm0.Unnamed_field2);
    this.TheKind = $Prm0.TheKind;
    this.PaddingInReg = $Prm0.PaddingInReg;
    this.InAllocaSRet = $Prm0.InAllocaSRet;
    this.IndirectByVal = $Prm0.IndirectByVal;
    this.IndirectRealign = $Prm0.IndirectRealign;
    this.SRetAfterThis = $Prm0.SRetAfterThis;
    this.InReg = $Prm0.InReg;
    this.CanBeFlattened = $Prm0.CanBeFlattened;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "TypeData=" + TypeData // NOI18N
              + ", Unnamed_field1=" + Unnamed_field1 // NOI18N
              + ", Unnamed_field2=" + Unnamed_field2 // NOI18N
              + ", TheKind=" + TheKind // NOI18N
              + ", PaddingInReg=" + PaddingInReg // NOI18N
              + ", InAllocaSRet=" + InAllocaSRet // NOI18N
              + ", IndirectByVal=" + IndirectByVal // NOI18N
              + ", IndirectRealign=" + IndirectRealign // NOI18N
              + ", SRetAfterThis=" + SRetAfterThis // NOI18N
              + ", InReg=" + InReg // NOI18N
              + ", CanBeFlattened=" + CanBeFlattened; // NOI18N
  }
}

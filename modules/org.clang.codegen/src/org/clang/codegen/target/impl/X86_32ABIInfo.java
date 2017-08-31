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

package org.clang.codegen.target.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.dyn_cast_CXXRecordDecl;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.target.impl.*;
import org.llvm.ir.CallingConv;
import org.llvm.ir.VectorType;
import org.llvm.ir.Type;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;


/// X86_32ABIInfo - The X86-32 ABI information.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 848,
 FQN="(anonymous namespace)::X86_32ABIInfo", NM="_ZN12_GLOBAL__N_113X86_32ABIInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_113X86_32ABIInfoE")
//</editor-fold>
public class X86_32ABIInfo extends /*public*/ SwiftABIInfo implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::Class">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 849,
   FQN="(anonymous namespace)::X86_32ABIInfo::Class", NM="_ZN12_GLOBAL__N_113X86_32ABIInfo5ClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_113X86_32ABIInfo5ClassE")
  //</editor-fold>
  private enum Class implements Native.NativeUIntEnum {
    Integer(0),
    Float(Integer.getValue() + 1);

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
    private Class(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  private static /*const*//*uint*/int MinABIStackAlignInBytes = 4;
  
  private boolean IsDarwinVectorABI;
  private boolean IsRetSmallStructInRegABI;
  private boolean IsWin32StructABI;
  private boolean IsSoftFloatABI;
  private boolean IsMCUABI;
  private /*uint*/int DefaultNumRegisterParameters;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::isRegisterSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 863,
   FQN="(anonymous namespace)::X86_32ABIInfo::isRegisterSize", NM="_ZN12_GLOBAL__N_113X86_32ABIInfo14isRegisterSizeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_113X86_32ABIInfo14isRegisterSizeEj")
  //</editor-fold>
  private static boolean isRegisterSize(/*uint*/int Size) {
    return (Size == 8 || Size == 16 || Size == 32 || Size == 64);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::isHomogeneousAggregateBaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 867,
   FQN="(anonymous namespace)::X86_32ABIInfo::isHomogeneousAggregateBaseType", NM="_ZNK12_GLOBAL__N_113X86_32ABIInfo30isHomogeneousAggregateBaseTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_32ABIInfo30isHomogeneousAggregateBaseTypeEN5clang8QualTypeE")
  //</editor-fold>
  @Override public/*private*/ boolean isHomogeneousAggregateBaseType(QualType Ty) /*const*//* override*/ {
    // FIXME: Assumes vectorcall is in use.
    return isX86VectorTypeForVectorCall(getContext(), new QualType(Ty));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::isHomogeneousAggregateSmallEnough">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 872,
   FQN="(anonymous namespace)::X86_32ABIInfo::isHomogeneousAggregateSmallEnough", NM="_ZNK12_GLOBAL__N_113X86_32ABIInfo33isHomogeneousAggregateSmallEnoughEPKN5clang4TypeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_32ABIInfo33isHomogeneousAggregateSmallEnoughEPKN5clang4TypeEy")
  //</editor-fold>
  @Override public/*private*/ boolean isHomogeneousAggregateSmallEnough(/*const*/ org.clang.ast.Type /*P*/ Ty, 
                                   long/*uint64_t*/ NumMembers) /*const*//* override*/ {
    // FIXME: Assumes vectorcall is in use.
    return isX86VectorCallAggregateSmallEnough(NumMembers);
  }

  
  
  /// shouldReturnTypeInRegister - Determine if the given type should be
  /// returned in a register (for the Darwin and MCU ABI).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::shouldReturnTypeInRegister">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1073,
   FQN="(anonymous namespace)::X86_32ABIInfo::shouldReturnTypeInRegister", NM="_ZNK12_GLOBAL__N_113X86_32ABIInfo26shouldReturnTypeInRegisterEN5clang8QualTypeERNS1_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_32ABIInfo26shouldReturnTypeInRegisterEN5clang8QualTypeERNS1_10ASTContextE")
  //</editor-fold>
  private boolean shouldReturnTypeInRegister(QualType Ty, 
                            final ASTContext /*&*/ Context) /*const*/ {
    long/*uint64_t*/ Size = Context.getTypeSize(new QualType(Ty));
    
    // For i386, type must be register sized.
    // For the MCU ABI, it only needs to be <= 8-byte
    if ((IsMCUABI && $greater_ulong_ullong(Size, $int2ullong(64))) || (!IsMCUABI && !X86_32ABIInfo.isRegisterSize($ulong2uint(Size)))) {
      return false;
    }
    if (Ty.$arrow().isVectorType()) {
      // 64- and 128- bit vectors inside structures are not returned in
      // registers.
      if (Size == $int2ullong(64) || Size == $int2ullong(128)) {
        return false;
      }
      
      return true;
    }
    
    // If this is a builtin, pointer, enum, complex type, member pointer, or
    // member function pointer it is ok.
    if ((Ty.$arrow().getAs$BuiltinType() != null) || Ty.$arrow().hasPointerRepresentation()
       || Ty.$arrow().isAnyComplexType() || Ty.$arrow().isEnumeralType()
       || Ty.$arrow().isBlockPointerType() || Ty.$arrow().isMemberPointerType()) {
      return true;
    }
    {
      
      // Arrays are treated like records.
      /*const*/ ConstantArrayType /*P*/ AT = Context.getAsConstantArrayType(new QualType(Ty));
      if ((AT != null)) {
        return shouldReturnTypeInRegister(AT.getElementType(), Context);
      }
    }
    
    // Otherwise, it must be a record type.
    /*const*/ RecordType /*P*/ RT = Ty.$arrow().getAs$RecordType();
    if (!(RT != null)) {
      return false;
    }
    
    // FIXME: Traverse bases here too.
    
    // Structure types are passed in register if all fields would be
    // passed in a register.
    for (/*const*/ FieldDecl /*P*/ FD : RT.getDecl().fields()) {
      // Empty fields are ignored.
      if (isEmptyField(Context, FD, true)) {
        continue;
      }
      
      // Check fields recursively.
      if (!shouldReturnTypeInRegister(FD.getType(), Context)) {
        return false;
      }
    }
    return true;
  }

  
  /// getIndirectResult - Give a source type \arg Ty, return a suitable result
  /// such that the argument will be passed in memory.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::getIndirectResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1333,
   FQN="(anonymous namespace)::X86_32ABIInfo::getIndirectResult", NM="_ZNK12_GLOBAL__N_113X86_32ABIInfo17getIndirectResultEN5clang8QualTypeEbRNS_7CCStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_32ABIInfo17getIndirectResultEN5clang8QualTypeEbRNS_7CCStateE")
  //</editor-fold>
  private ABIArgInfo getIndirectResult(QualType Ty, boolean ByVal, 
                   final CCState /*&*/ State) /*const*/ {
    if (!ByVal) {
      if ((State.FreeRegs != 0)) {
        --State.FreeRegs; // Non-byval indirects just use one pointer.
        if (!IsMCUABI) {
          return getNaturalAlignIndirectInReg(new QualType(Ty));
        }
      }
      return getNaturalAlignIndirect(new QualType(Ty), false);
    }
    
    // Compute the byval alignment.
    /*uint*/int TypeAlign = $div_uint(getContext().getTypeAlign(new QualType(Ty)), 8);
    /*uint*/int StackAlign = getTypeStackAlignInBytes(new QualType(Ty), TypeAlign);
    if (StackAlign == 0) {
      return ABIArgInfo.getIndirect(CharUnits.fromQuantity(4), /*ByVal=*/ true);
    }
    
    // If the stack alignment is less than the type alignment, realign the
    // argument.
    boolean Realign = $greater_uint(TypeAlign, StackAlign);
    return ABIArgInfo.getIndirect(CharUnits.fromQuantity($uint2long(StackAlign)), 
        /*ByVal=*/ true, Realign);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::getIndirectReturnResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1188,
   FQN="(anonymous namespace)::X86_32ABIInfo::getIndirectReturnResult", NM="_ZNK12_GLOBAL__N_113X86_32ABIInfo23getIndirectReturnResultEN5clang8QualTypeERNS_7CCStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_32ABIInfo23getIndirectReturnResultEN5clang8QualTypeERNS_7CCStateE")
  //</editor-fold>
  private ABIArgInfo getIndirectReturnResult(QualType RetTy, final CCState /*&*/ State) /*const*/ {
    // If the return value is indirect, then the hidden argument is consuming one
    // integer register.
    if ((State.FreeRegs != 0)) {
      --State.FreeRegs;
      if (!IsMCUABI) {
        return getNaturalAlignIndirectInReg(new QualType(RetTy));
      }
    }
    return getNaturalAlignIndirect(new QualType(RetTy), /*ByVal=*/ false);
  }

  
  /// \brief Return the alignment to use for the given type on the stack.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::getTypeStackAlignInBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1312,
   FQN="(anonymous namespace)::X86_32ABIInfo::getTypeStackAlignInBytes", NM="_ZNK12_GLOBAL__N_113X86_32ABIInfo24getTypeStackAlignInBytesEN5clang8QualTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_32ABIInfo24getTypeStackAlignInBytesEN5clang8QualTypeEj")
  //</editor-fold>
  private /*uint*/int getTypeStackAlignInBytes(QualType Ty, 
                          /*uint*/int Align) /*const*/ {
    // Otherwise, if the alignment is less than or equal to the minimum ABI
    // alignment, just use the default; the backend will handle this.
    if ($lesseq_uint(Align, MinABIStackAlignInBytes)) {
      return 0; // Use default alignment.
    }
    
    // On non-Darwin, the stack type alignment is always 4.
    if (!IsDarwinVectorABI) {
      // Set explicit alignment, since we may need to realign the top.
      return MinABIStackAlignInBytes;
    }
    
    // Otherwise, if the type contains an SSE vector type, the alignment is 16.
    if ($greatereq_uint(Align, 16) && (isSSEVectorType(getContext(), new QualType(Ty))
       || isRecordWithSSEVectorType(getContext(), new QualType(Ty)))) {
      return 16;
    }
    
    return MinABIStackAlignInBytes;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::classify">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1357,
   FQN="(anonymous namespace)::X86_32ABIInfo::classify", NM="_ZNK12_GLOBAL__N_113X86_32ABIInfo8classifyEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_32ABIInfo8classifyEN5clang8QualTypeE")
  //</editor-fold>
  private X86_32ABIInfo.Class classify(QualType Ty) /*const*/ {
    /*const*/ org.clang.ast.Type /*P*/ T = isSingleElementStruct(new QualType(Ty), getContext());
    if (!(T != null)) {
      T = Ty.getTypePtr();
    }
    {
      
      /*const*/ BuiltinType /*P*/ BT = T.getAs$BuiltinType();
      if ((BT != null)) {
        BuiltinType.Kind K = BT.getKind();
        if (K == BuiltinType.Kind.Float || K == BuiltinType.Kind.Double) {
          return Class.Float;
        }
      }
    }
    return Class.Integer;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::classifyReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1199,
   FQN="(anonymous namespace)::X86_32ABIInfo::classifyReturnType", NM="_ZNK12_GLOBAL__N_113X86_32ABIInfo18classifyReturnTypeEN5clang8QualTypeERNS_7CCStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_32ABIInfo18classifyReturnTypeEN5clang8QualTypeERNS_7CCStateE")
  //</editor-fold>
  private ABIArgInfo classifyReturnType(QualType RetTy, 
                    final CCState /*&*/ State) /*const*/ {
    if (RetTy.$arrow().isVoidType()) {
      return ABIArgInfo.getIgnore();
    }
    
    type$ref</*const*/ org.clang.ast.Type /*P*/ > Base = create_type$null$ref(null);
    ulong$ref NumElts = create_ulong$ref($int2ulong(0));
    if (State.CC == CallingConv.X86_VectorCall
       && isHomogeneousAggregate(new QualType(RetTy), Base, NumElts)) {
      // The LLVM struct type for such an aggregate should lower properly.
      return ABIArgInfo.getDirect();
    }
    {
      
      /*const*/ org.llvm.ir.VectorType /*P*/ VT = RetTy.$arrow().getAs(org.llvm.ir.VectorType.class);
      if ((VT != null)) {
        // On Darwin, some vectors are returned in registers.
        if (IsDarwinVectorABI) {
          long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(RetTy));
          
          // 128-bit vectors are a special case; they are returned in
          // registers and we need to make sure to pick a type the LLVM
          // backend will like.
          if (Size == $int2ullong(128)) {
            return ABIArgInfo.getDirect(org.llvm.ir.VectorType.get(Type.getInt64Ty(getVMContext()), 2));
          }
          
          // Always return in register if it fits in a general purpose
          // register, or if it is 64 bits and has a single element.
          if ((Size == $int2ullong(8) || Size == $int2ullong(16) || Size == $int2ullong(32))
             || (Size == $int2ullong(64) && VT.getNumElements() == 1)) {
            return ABIArgInfo.getDirect(IntegerType.get(getVMContext(), 
                    $ulong2uint(Size)));
          }
          
          return getIndirectReturnResult(new QualType(RetTy), State);
        }
        
        return ABIArgInfo.getDirect();
      }
    }
    if (isAggregateTypeForABI(new QualType(RetTy))) {
      {
        /*const*/ RecordType /*P*/ RT = RetTy.$arrow().getAs$RecordType();
        if ((RT != null)) {
          // Structures with flexible arrays are always indirect.
          if (RT.getDecl().hasFlexibleArrayMember()) {
            return getIndirectReturnResult(new QualType(RetTy), State);
          }
        }
      }
      
      // If specified, structs and unions are always indirect.
      if (!IsRetSmallStructInRegABI && !RetTy.$arrow().isAnyComplexType()) {
        return getIndirectReturnResult(new QualType(RetTy), State);
      }
      
      // Ignore empty structs/unions.
      if (isEmptyRecord(getContext(), new QualType(RetTy), true)) {
        return ABIArgInfo.getIgnore();
      }
      
      // Small structures which are register sized are generally returned
      // in a register.
      if (shouldReturnTypeInRegister(new QualType(RetTy), getContext())) {
        long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(RetTy));
        {
          
          // As a special-case, if the struct is a "single-element" struct, and
          // the field is of type "float" or "double", return it in a
          // floating-point register. (MSVC does not apply this special case.)
          // We apply a similar transformation for pointer types to improve the
          // quality of the generated IR.
          /*const*/ org.clang.ast.Type /*P*/ SeltTy = isSingleElementStruct(new QualType(RetTy), getContext());
          if ((SeltTy != null)) {
            if ((!IsWin32StructABI && SeltTy.isRealFloatingType())
               || SeltTy.hasPointerRepresentation()) {
              return ABIArgInfo.getDirect(CGT.ConvertType(new QualType(SeltTy, 0)));
            }
          }
        }
        
        // FIXME: We should be able to narrow this integer in cases with dead
        // padding.
        return ABIArgInfo.getDirect(IntegerType.get(getVMContext(), $ulong2uint(Size)));
      }
      
      return getIndirectReturnResult(new QualType(RetTy), State);
    }
    {
      
      // Treat an enum type as its underlying type.
      /*const*/ EnumType /*P*/ EnumTy = RetTy.$arrow().getAs$EnumType();
      if ((EnumTy != null)) {
        RetTy.$assignMove(EnumTy.getDecl().getIntegerType());
      }
    }
    
    return (RetTy.$arrow().isPromotableIntegerType() ? ABIArgInfo.getExtend() : ABIArgInfo.getDirect());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::classifyArgumentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1449,
   FQN="(anonymous namespace)::X86_32ABIInfo::classifyArgumentType", NM="_ZNK12_GLOBAL__N_113X86_32ABIInfo20classifyArgumentTypeEN5clang8QualTypeERNS_7CCStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_32ABIInfo20classifyArgumentTypeEN5clang8QualTypeERNS_7CCStateE")
  //</editor-fold>
  private ABIArgInfo classifyArgumentType(QualType Ty, 
                      final CCState /*&*/ State) /*const*/ {
    // FIXME: Set alignment on indirect arguments.
    Ty.$assignMove(useFirstFieldIfTransparentUnion(new QualType(Ty)));
    
    // Check with the C++ ABI first.
    /*const*/ RecordType /*P*/ RT = Ty.$arrow().getAs$RecordType();
    if ((RT != null)) {
      CGCXXABI.RecordArgABI RAA = getRecordArgABI(RT, getCXXABI());
      if (RAA == CGCXXABI.RecordArgABI.RAA_Indirect) {
        return getIndirectResult(new QualType(Ty), false, State);
      } else if (RAA == CGCXXABI.RecordArgABI.RAA_DirectInMemory) {
        // The field index doesn't matter, we'll fix it up later.
        return ABIArgInfo.getInAlloca(/*FieldIndex=*/ 0);
      }
    }
    
    // vectorcall adds the concept of a homogenous vector aggregate, similar
    // to other targets.
    type$ref</*const*/ org.clang.ast.Type /*P*/ > Base = create_type$null$ref(null);
    ulong$ref NumElts = create_ulong$ref($int2ulong(0));
    if (State.CC == CallingConv.X86_VectorCall
       && isHomogeneousAggregate(new QualType(Ty), Base, NumElts)) {
      if ($greatereq_uint_ulong(State.FreeSSERegs, NumElts.$deref())) {
        State.FreeSSERegs -= NumElts.$deref();
        if (Ty.$arrow().isBuiltinType() || Ty.$arrow().isVectorType()) {
          return ABIArgInfo.getDirect();
        }
        return ABIArgInfo.getExpand();
      }
      return getIndirectResult(new QualType(Ty), /*ByVal=*/ false, State);
    }
    if (isAggregateTypeForABI(new QualType(Ty))) {
      // Structures with flexible arrays are always indirect.
      // FIXME: This should not be byval!
      if ((RT != null) && RT.getDecl().hasFlexibleArrayMember()) {
        return getIndirectResult(new QualType(Ty), true, State);
      }
      
      // Ignore empty structs/unions on non-Windows.
      if (!IsWin32StructABI && isEmptyRecord(getContext(), new QualType(Ty), true)) {
        return ABIArgInfo.getIgnore();
      }
      
      final LLVMContext /*&*/ $LLVMContext = getVMContext();
      IntegerType /*P*/ Int32 = Type.getInt32Ty($LLVMContext);
      bool$ref NeedsPadding = create_bool$ref(false);
      bool$ref InReg = create_bool$ref();
      if (shouldAggregateUseDirect(new QualType(Ty), State, InReg, NeedsPadding)) {
        /*uint*/int SizeInRegs = $ullong2uint($div_ullong((getContext().getTypeSize(new QualType(Ty)) + $int2ullong(31)), $int2ullong(32)));
        SmallVector<Type /*P*/ > Elements/*J*/= new SmallVector<Type /*P*/ >(JD$UInt_T$C$R.INSTANCE, 3, SizeInRegs, Int32, (Type /*P*/ )null);
        Type /*P*/ Result = StructType.get($LLVMContext, new ArrayRef<Type /*P*/ >(Elements, true));
        if (InReg.$deref()) {
          return ABIArgInfo.getDirectInReg(Result);
        } else {
          return ABIArgInfo.getDirect(Result);
        }
      }
      IntegerType /*P*/ PaddingType = NeedsPadding.$deref() ? Int32 : null;
      
      // Expand small (<= 128-bit) record types when we know that the stack layout
      // of those arguments will match the struct. This is important because the
      // LLVM backend isn't smart enough to remove byval, which inhibits many
      // optimizations.
      // Don't do this for the MCU if there are still free integer registers
      // (see X86_64 ABI for full explanation).
      if ($lesseq_ulong_ullong(getContext().getTypeSize(new QualType(Ty)), $int2ullong(4 * 32))
         && (!IsMCUABI || State.FreeRegs == 0) && canExpandIndirectArgument(new QualType(Ty))) {
        return ABIArgInfo.getExpandWithPadding(State.CC == CallingConv.X86_FastCall
               || State.CC == CallingConv.X86_VectorCall, 
            PaddingType);
      }
      
      return getIndirectResult(new QualType(Ty), true, State);
    }
    {
      
      /*const*/ VectorType /*P*/ VT = Ty.$arrow().getAs(VectorType.class);
      if ((VT != null)) {
        // On Darwin, some vectors are passed in memory, we handle this by passing
        // it as an i8/i16/i32/i64.
        if (IsDarwinVectorABI) {
          long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(Ty));
          if ((Size == $int2ullong(8) || Size == $int2ullong(16) || Size == $int2ullong(32))
             || (Size == $int2ullong(64) && VT.getNumElements() == 1)) {
            return ABIArgInfo.getDirect(IntegerType.get(getVMContext(), 
                    $ulong2uint(Size)));
          }
        }
        if (IsX86_MMXType(CGT.ConvertType(new QualType(Ty)))) {
          return ABIArgInfo.getDirect(IntegerType.get(getVMContext(), 64));
        }
        
        return ABIArgInfo.getDirect();
      }
    }
    {
      
      /*const*/ EnumType /*P*/ EnumTy = Ty.$arrow().getAs$EnumType();
      if ((EnumTy != null)) {
        Ty.$assignMove(EnumTy.getDecl().getIntegerType());
      }
    }
    
    boolean InReg = shouldPrimitiveUseInReg(new QualType(Ty), State);
    if (Ty.$arrow().isPromotableIntegerType()) {
      if (InReg) {
        return ABIArgInfo.getExtendInReg();
      }
      return ABIArgInfo.getExtend();
    }
    if (InReg) {
      return ABIArgInfo.getDirectInReg();
    }
    return ABIArgInfo.getDirect();
  }

  /// \brief Updates the number of available free registers, returns 
  /// true if any registers were allocated.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::updateFreeRegs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1370,
   FQN="(anonymous namespace)::X86_32ABIInfo::updateFreeRegs", NM="_ZNK12_GLOBAL__N_113X86_32ABIInfo14updateFreeRegsEN5clang8QualTypeERNS_7CCStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_32ABIInfo14updateFreeRegsEN5clang8QualTypeERNS_7CCStateE")
  //</editor-fold>
  private boolean updateFreeRegs(QualType Ty, final CCState /*&*/ State) /*const*/ {
    if (!IsSoftFloatABI) {
      Class C = classify(new QualType(Ty));
      if (C == Class.Float) {
        return false;
      }
    }
    
    /*uint*/int Size = $ulong2uint(getContext().getTypeSize(new QualType(Ty)));
    /*uint*/int SizeInRegs = $div_uint((Size + 31), 32);
    if (SizeInRegs == 0) {
      return false;
    }
    if (!IsMCUABI) {
      if ($greater_uint(SizeInRegs, State.FreeRegs)) {
        State.FreeRegs = 0;
        return false;
      }
    } else {
      // The MCU psABI allows passing parameters in-reg even if there are
      // earlier parameters that are passed on the stack. Also,
      // it does not allow passing >8-byte structs in-register,
      // even if there are 3 free registers available.
      if ($greater_uint(SizeInRegs, State.FreeRegs) || $greater_uint(SizeInRegs, 2)) {
        return false;
      }
    }
    
    State.FreeRegs -= SizeInRegs;
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::shouldAggregateUseDirect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1401,
   FQN="(anonymous namespace)::X86_32ABIInfo::shouldAggregateUseDirect", NM="_ZNK12_GLOBAL__N_113X86_32ABIInfo24shouldAggregateUseDirectEN5clang8QualTypeERNS_7CCStateERbS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_32ABIInfo24shouldAggregateUseDirectEN5clang8QualTypeERNS_7CCStateERbS5_")
  //</editor-fold>
  private boolean shouldAggregateUseDirect(QualType Ty, final CCState /*&*/ State, 
                          final bool$ref/*bool &*/ InReg, 
                          final bool$ref/*bool &*/ NeedsPadding) /*const*/ {
    // On Windows, aggregates other than HFAs are never passed in registers, and
    // they do not consume register slots. Homogenous floating-point aggregates
    // (HFAs) have already been dealt with at this point.
    if (IsWin32StructABI && isAggregateTypeForABI(new QualType(Ty))) {
      return false;
    }
    
    NeedsPadding.$set(false);
    InReg.$set(!IsMCUABI);
    if (!updateFreeRegs(new QualType(Ty), State)) {
      return false;
    }
    if (IsMCUABI) {
      return true;
    }
    if (State.CC == CallingConv.X86_FastCall
       || State.CC == CallingConv.X86_VectorCall) {
      if ($lesseq_ulong_ullong(getContext().getTypeSize(new QualType(Ty)), $int2ullong(32)) && (State.FreeRegs != 0)) {
        NeedsPadding.$set(true);
      }
      
      return false;
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::shouldPrimitiveUseInReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1430,
   FQN="(anonymous namespace)::X86_32ABIInfo::shouldPrimitiveUseInReg", NM="_ZNK12_GLOBAL__N_113X86_32ABIInfo23shouldPrimitiveUseInRegEN5clang8QualTypeERNS_7CCStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_32ABIInfo23shouldPrimitiveUseInRegEN5clang8QualTypeERNS_7CCStateE")
  //</editor-fold>
  private boolean shouldPrimitiveUseInReg(QualType Ty, final CCState /*&*/ State) /*const*/ {
    if (!updateFreeRegs(new QualType(Ty), State)) {
      return false;
    }
    if (IsMCUABI) {
      return false;
    }
    if (State.CC == CallingConv.X86_FastCall
       || State.CC == CallingConv.X86_VectorCall) {
      if ($greater_ulong_ullong(getContext().getTypeSize(new QualType(Ty)), $int2ullong(32))) {
        return false;
      }
      
      return (Ty.$arrow().isIntegralOrEnumerationType() || Ty.$arrow().isPointerType()
         || Ty.$arrow().isReferenceType());
    }
    
    return true;
  }

  
  
  /// Test whether an argument type which is to be passed indirectly (on the
  /// stack) would have the equivalent layout if it was expanded into separate
  /// arguments. If so, we prefer to do the latter to avoid inhibiting
  /// optimizations.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::canExpandIndirectArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1142,
   FQN="(anonymous namespace)::X86_32ABIInfo::canExpandIndirectArgument", NM="_ZNK12_GLOBAL__N_113X86_32ABIInfo25canExpandIndirectArgumentEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_32ABIInfo25canExpandIndirectArgumentEN5clang8QualTypeE")
  //</editor-fold>
  private boolean canExpandIndirectArgument(QualType Ty) /*const*/ {
    // We can only expand structure types.
    /*const*/ RecordType /*P*/ RT = Ty.$arrow().getAs$RecordType();
    if (!(RT != null)) {
      return false;
    }
    /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
    {
      /*const*/ CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(RD);
      if ((CXXRD != null)) {
        if (!IsWin32StructABI) {
          // On non-Windows, we have to conservatively match our old bitcode
          // prototypes in order to be ABI-compatible at the bitcode level.
          if (!CXXRD.isCLike()) {
            return false;
          }
        } else {
          // Don't do this for dynamic classes.
          if (CXXRD.isDynamicClass()) {
            return false;
          }
          // Don't do this if there are any non-empty bases.
          for (final /*const*/ CXXBaseSpecifier /*&*/ Base : CXXRD.bases$Const()) {
            if (!isEmptyRecord(getContext(), Base.getType(), /*AllowArrays=*/ true)) {
              return false;
            }
          }
        }
      }
    }
    
    long/*uint64_t*/ Size = $int2ulong(0);
    
    for (/*const*/ FieldDecl /*P*/ FD : RD.fields()) {
      // Scalar arguments on the stack get 4 byte alignment on x86. If the
      // argument is smaller than 32-bits, expanding the struct will create
      // alignment padding.
      if (!is32Or64BitBasicType(FD.getType(), getContext())) {
        return false;
      }
      
      // FIXME: Reject bit-fields wholesale; there are two problems, we don't know
      // how to expand them yet, and the predicate for telling if a bitfield still
      // counts as "basic" is more complicated than what we were doing previously.
      if (FD.isBitField()) {
        return false;
      }
      
      Size += getContext().getTypeSize(FD.getType());
    }
    
    // We can do this if there was no alignment padding.
    return Size == getContext().getTypeSize(new QualType(Ty));
  }

  
  /// \brief Rewrite the function info so that all memory arguments use
  /// inalloca.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::rewriteWithInAlloca">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1646,
   FQN="(anonymous namespace)::X86_32ABIInfo::rewriteWithInAlloca", NM="_ZNK12_GLOBAL__N_113X86_32ABIInfo19rewriteWithInAllocaERN5clang7CodeGen14CGFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_32ABIInfo19rewriteWithInAllocaERN5clang7CodeGen14CGFunctionInfoE")
  //</editor-fold>
  private void rewriteWithInAlloca(final CGFunctionInfo /*&*/ FI) /*const*/ {
    assert (IsWin32StructABI) : "inalloca only supported on win32";
    
    // Build a packed struct type for all of the arguments in memory.
    SmallVector<Type /*P*/ > FrameFields/*J*/= new SmallVector<Type /*P*/ >(6, (Type /*P*/ )null);
    
    // The stack alignment is always 4.
    CharUnits StackAlign = CharUnits.fromQuantity(4);
    
    CharUnits StackOffset/*J*/= new CharUnits();
    type$ptr<CGFunctionInfoArgInfo /*P*/ > I = $tryClone(FI.arg_begin());
    type$ptr<CGFunctionInfoArgInfo /*P*/ > E = $tryClone(FI.arg_end());
    
    // Put 'this' into the struct before 'sret', if necessary.
    boolean IsThisCall = FI.getCallingConvention() == CallingConv.X86_ThisCall;
    final ABIArgInfo /*&*/ Ret = FI.getReturnInfo();
    if (Ret.isIndirect() && Ret.isSRetAfterThis() && !IsThisCall
       && isArgInAlloca(I./*->*/$star().info)) {
      addFieldToArgStruct(FrameFields, StackOffset, I./*->*/$star().info, I./*->*/$star().type.$QualType());
      I.$preInc();
    }
    
    // Put the sret parameter into the inalloca struct if it's in memory.
    if (Ret.isIndirect() && !Ret.getInReg()) {
      CanQual<org.clang.ast.Type> PtrTy = getContext().getPointerType(FI.getReturnType());
      addFieldToArgStruct(FrameFields, StackOffset, Ret, PtrTy.$QualType());
      // On Windows, the hidden sret parameter is always returned in eax.
      Ret.setInAllocaSRet(IsWin32StructABI);
    }
    
    // Skip the 'this' parameter in ecx.
    if (IsThisCall) {
      I.$preInc();
    }
    
    // Put arguments passed in memory into the struct.
    for (; $noteq_ptr(I, E); I.$preInc()) {
      if (isArgInAlloca(I./*->*/$star().info)) {
        addFieldToArgStruct(FrameFields, StackOffset, I./*->*/$star().info, I./*->*/$star().type.$QualType());
      }
    }
    
    FI.setArgStruct(StructType.get(getVMContext(), new ArrayRef<Type /*P*/ >(FrameFields, true), 
            /*isPacked=*/ true), 
        new CharUnits(StackAlign));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::addFieldToArgStruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1599,
   FQN="(anonymous namespace)::X86_32ABIInfo::addFieldToArgStruct", NM="_ZNK12_GLOBAL__N_113X86_32ABIInfo19addFieldToArgStructERN4llvm11SmallVectorIPNS1_4TypeELj6EEERN5clang9CharUnitsERNS7_7CodeGen10ABIArgInfoENS7_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_32ABIInfo19addFieldToArgStructERN4llvm11SmallVectorIPNS1_4TypeELj6EEERN5clang9CharUnitsERNS7_7CodeGen10ABIArgInfoENS7_8QualTypeE")
  //</editor-fold>
  private void addFieldToArgStruct(final SmallVector<Type /*P*/ > /*&*/ FrameFields, 
                     final CharUnits /*&*/ StackOffset, final ABIArgInfo /*&*/ Info, 
                     QualType Type) /*const*/ {
    // Arguments are always 4-byte-aligned.
    CharUnits FieldAlign = CharUnits.fromQuantity(4);
    assert (StackOffset.isMultipleOf(new CharUnits(FieldAlign))) : "unaligned inalloca struct";
    Info.$assignMove(ABIArgInfo.getInAlloca(FrameFields.size()));
    FrameFields.push_back(CGT.ConvertTypeForMem(new QualType(Type)));
    StackOffset.$addassign(getContext().getTypeSizeInChars(/*NO_COPY*/Type));
    
    // Insert padding bytes to respect alignment.
    CharUnits FieldEnd = new CharUnits(StackOffset);
    StackOffset.$assignMove(FieldEnd.alignTo(FieldAlign));
    if (StackOffset.$noteq(FieldEnd)) {
      CharUnits NumBytes = StackOffset.$sub(FieldEnd);
      org.llvm.ir.Type /*P*/ Ty = org.llvm.ir.Type.getInt8Ty(getVMContext());
      Ty = org.llvm.ir.ArrayType.get(Ty, NumBytes.getQuantity());
      FrameFields.push_back(Ty);
    }
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::computeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1557,
   FQN="(anonymous namespace)::X86_32ABIInfo::computeInfo", NM="_ZNK12_GLOBAL__N_113X86_32ABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_32ABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE")
  //</editor-fold>
  @Override public void computeInfo(final CGFunctionInfo /*&*/ FI) /*const*//* override*/ {
    CCState State/*J*/= new CCState(FI.getCallingConvention());
    if (IsMCUABI) {
      State.FreeRegs = 3;
    } else if (State.CC == CallingConv.X86_FastCall) {
      State.FreeRegs = 2;
    } else if (State.CC == CallingConv.X86_VectorCall) {
      State.FreeRegs = 2;
      State.FreeSSERegs = 6;
    } else if (FI.getHasRegParm()) {
      State.FreeRegs = FI.getRegParm();
    } else {
      State.FreeRegs = DefaultNumRegisterParameters;
    }
    if (!getCXXABI().classifyReturnType(FI)) {
      FI.getReturnInfo().$assignMove(classifyReturnType(FI.getReturnType().$QualType(), State));
    } else if (FI.getReturnInfo().isIndirect()) {
      // The C++ ABI is not aware of register usage, so we have to check if the
      // return value was sret and put it in a register ourselves if appropriate.
      if ((State.FreeRegs != 0)) {
        --State.FreeRegs; // The sret parameter consumes a register.
        if (!IsMCUABI) {
          FI.getReturnInfo().setInReg(true);
        }
      }
    }
    
    // The chain argument effectively gives us another free register.
    if (FI.isChainCall()) {
      ++State.FreeRegs;
    }
    
    boolean UsedInAlloca = false;
    for (final CGFunctionInfoArgInfo /*&*/ I : FI.arguments()) {
      I.info.$assignMove(classifyArgumentType(I.type.$QualType(), State));
      UsedInAlloca |= (I.info.getKind() == ABIArgInfo.Kind.InAlloca);
    }
    
    // If we needed to use inalloca for any argument, do a second pass and rewrite
    // all the memory arguments to use inalloca.
    if (UsedInAlloca) {
      rewriteWithInAlloca(FI);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::EmitVAArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1691,
   FQN="(anonymous namespace)::X86_32ABIInfo::EmitVAArg", NM="_ZNK12_GLOBAL__N_113X86_32ABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_32ABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE")
  //</editor-fold>
  @Override public Address EmitVAArg(final CodeGenFunction /*&*/ CGF, 
           Address VAListAddr, QualType Ty) /*const*//* override*/ {
    
    std.pair<CharUnits, CharUnits> TypeInfo = getContext().getTypeInfoInChars(new QualType(Ty));
    
    // x86-32 changes the alignment of certain arguments on the stack.
    //
    // Just messing with TypeInfo like this works because we never pass
    // anything indirectly.
    TypeInfo.second.$assignMove(CharUnits.fromQuantity($uint2long(getTypeStackAlignInBytes(new QualType(Ty), $long2uint(TypeInfo.second.getQuantity())))));
    
    return emitVoidPtrVAArg(CGF, new Address(VAListAddr), new QualType(Ty), /*Indirect*/ false, 
        new std.pairTypeType<CharUnits, CharUnits>(TypeInfo), CharUnits.fromQuantity(4), 
        /*AllowHigherAlign*/ true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::X86_32ABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 916,
   FQN="(anonymous namespace)::X86_32ABIInfo::X86_32ABIInfo", NM="_ZN12_GLOBAL__N_113X86_32ABIInfoC1ERN5clang7CodeGen12CodeGenTypesEbbbjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_113X86_32ABIInfoC1ERN5clang7CodeGen12CodeGenTypesEbbbjb")
  //</editor-fold>
  public X86_32ABIInfo(final CodeGenTypes /*&*/ CGT, boolean DarwinVectorABI, 
      boolean RetSmallStructInRegABI, boolean Win32StructABI, 
      /*uint*/int NumRegisterParameters, boolean SoftFloatABI) {
    // : SwiftABIInfo(CGT), IsDarwinVectorABI(DarwinVectorABI), IsRetSmallStructInRegABI(RetSmallStructInRegABI), IsWin32StructABI(Win32StructABI), IsSoftFloatABI(SoftFloatABI), IsMCUABI(CGT.getTarget().getTriple().isOSIAMCU()), DefaultNumRegisterParameters(NumRegisterParameters) 
    //START JInit
    super(CGT);
    this.IsDarwinVectorABI = DarwinVectorABI;
    this.IsRetSmallStructInRegABI = RetSmallStructInRegABI;
    this.IsWin32StructABI = Win32StructABI;
    this.IsSoftFloatABI = SoftFloatABI;
    this.IsMCUABI = CGT.getTarget().getTriple().isOSIAMCU();
    this.DefaultNumRegisterParameters = NumRegisterParameters;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::shouldPassIndirectlyForSwift">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 926,
   FQN="(anonymous namespace)::X86_32ABIInfo::shouldPassIndirectlyForSwift", NM="_ZNK12_GLOBAL__N_113X86_32ABIInfo28shouldPassIndirectlyForSwiftEN5clang9CharUnitsEN4llvm8ArrayRefIPNS3_4TypeEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_32ABIInfo28shouldPassIndirectlyForSwiftEN5clang9CharUnitsEN4llvm8ArrayRefIPNS3_4TypeEEEb")
  //</editor-fold>
  @Override public boolean shouldPassIndirectlyForSwift(CharUnits totalSize, 
                              ArrayRef<Type /*P*/ > scalars, 
                              boolean asReturnValue) /*const*//* override*/ {
    // LLVM's x86-32 lowering currently only assigns up to three
    // integer registers and three fp registers.  Oddly, it'll use up to
    // four vector registers for vectors, but those can overlap with the
    // scalar registers.
    return occupiesMoreThan(CGT, new ArrayRef<Type /*P*/ >(scalars), /*total*/ 3);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32ABIInfo::~X86_32ABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 848,
   FQN="(anonymous namespace)::X86_32ABIInfo::~X86_32ABIInfo", NM="_ZN12_GLOBAL__N_113X86_32ABIInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_113X86_32ABIInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "IsDarwinVectorABI=" + IsDarwinVectorABI // NOI18N
              + ", IsRetSmallStructInRegABI=" + IsRetSmallStructInRegABI // NOI18N
              + ", IsWin32StructABI=" + IsWin32StructABI // NOI18N
              + ", IsSoftFloatABI=" + IsSoftFloatABI // NOI18N
              + ", IsMCUABI=" + IsMCUABI // NOI18N
              + ", DefaultNumRegisterParameters=" + DefaultNumRegisterParameters // NOI18N
              + super.toString(); // NOI18N
  }
}

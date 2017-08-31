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

package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.llvm.ir.CallingConv;
import org.clang.basic.target.TargetInfo;
import org.clang.ast.VectorType;
import org.clang.ast.Type;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.codegen.target.impl.TargetInfoStatics.isEmptyRecord;


// FIXME: All of this stuff should be part of the target interface
// somehow. It is currently here because it is not clear how to factor
// the targets to support this, since the Targets currently live in a
// layer below types n'stuff.

/// ABIInfo - Target specific hooks for defining how a type should be
/// passed or returned from functions.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ABIInfo.h", line = 49,
 FQN="clang::CodeGen::ABIInfo", NM="_ZN5clang7CodeGen7ABIInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen7ABIInfoE")
//</editor-fold>
public abstract class ABIInfo implements Destructors.ClassWithDestructor {
/*public:*/
  public final CodeGenTypes /*&*/ CGT;
/*protected:*/
  protected /*uint*/int RuntimeCC;
  protected /*uint*/int BuiltinCC;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::ABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ABIInfo.h", line = 56,
   FQN="clang::CodeGen::ABIInfo::ABIInfo", NM="_ZN5clang7CodeGen7ABIInfoC1ERNS0_12CodeGenTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen7ABIInfoC1ERNS0_12CodeGenTypesE")
  //</editor-fold>
  public ABIInfo(final CodeGenTypes /*&*/ cgt) {
    // : CGT(cgt), RuntimeCC(CallingConv::C), BuiltinCC(CallingConv::C) 
    //START JInit
    this./*&*/CGT=/*&*/cgt;
    this.RuntimeCC = CallingConv.C;
    this.BuiltinCC = CallingConv.C;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::~ABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 70,
   FQN="clang::CodeGen::ABIInfo::~ABIInfo", NM="_ZN5clang7CodeGen7ABIInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen7ABIInfoD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::supportsSwift">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ABIInfo.h", line = 63,
   FQN="clang::CodeGen::ABIInfo::supportsSwift", NM="_ZNK5clang7CodeGen7ABIInfo13supportsSwiftEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen7ABIInfo13supportsSwiftEv")
  //</editor-fold>
  public /*virtual*/ boolean supportsSwift() /*const*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::getCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 141,
   FQN="clang::CodeGen::ABIInfo::getCXXABI", NM="_ZNK5clang7CodeGen7ABIInfo9getCXXABIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen7ABIInfo9getCXXABIEv")
  //</editor-fold>
  public CGCXXABI /*&*/ getCXXABI() /*const*/ {
    return CGT.getCXXABI();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 145,
   FQN="clang::CodeGen::ABIInfo::getContext", NM="_ZNK5clang7CodeGen7ABIInfo10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen7ABIInfo10getContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getContext() /*const*/ {
    return CGT.getContext();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::getVMContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 149,
   FQN="clang::CodeGen::ABIInfo::getVMContext", NM="_ZNK5clang7CodeGen7ABIInfo12getVMContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen7ABIInfo12getVMContextEv")
  //</editor-fold>
  public LLVMContext /*&*/ getVMContext() /*const*/ {
    return CGT.getLLVMContext();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::getDataLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 153,
   FQN="clang::CodeGen::ABIInfo::getDataLayout", NM="_ZNK5clang7CodeGen7ABIInfo13getDataLayoutEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen7ABIInfo13getDataLayoutEv")
  //</editor-fold>
  public /*const*/ DataLayout /*&*/ getDataLayout() /*const*/ {
    return CGT.getDataLayout();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::getTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 157,
   FQN="clang::CodeGen::ABIInfo::getTarget", NM="_ZNK5clang7CodeGen7ABIInfo9getTargetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen7ABIInfo9getTargetEv")
  //</editor-fold>
  public /*const*/ TargetInfo /*&*/ getTarget() /*const*/ {
    return CGT.getTarget();
  }

  
  /// Return the calling convention to use for system runtime
  /// functions.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::getRuntimeCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ABIInfo.h", line = 73,
   FQN="clang::CodeGen::ABIInfo::getRuntimeCC", NM="_ZNK5clang7CodeGen7ABIInfo12getRuntimeCCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen7ABIInfo12getRuntimeCCEv")
  //</editor-fold>
  public /*uint*/int getRuntimeCC() /*const*/ {
    return RuntimeCC;
  }

  
  /// Return the calling convention to use for compiler builtins
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::getBuiltinCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ABIInfo.h", line = 78,
   FQN="clang::CodeGen::ABIInfo::getBuiltinCC", NM="_ZNK5clang7CodeGen7ABIInfo12getBuiltinCCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen7ABIInfo12getBuiltinCCEv")
  //</editor-fold>
  public /*uint*/int getBuiltinCC() /*const*/ {
    return BuiltinCC;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::computeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ABIInfo.h", line = 82,
   FQN="clang::CodeGen::ABIInfo::computeInfo", NM="_ZNK5clang7CodeGen7ABIInfo11computeInfoERNS0_14CGFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen7ABIInfo11computeInfoERNS0_14CGFunctionInfoE")
  //</editor-fold>
  public abstract /*virtual*/ void computeInfo(final CGFunctionInfo /*&*/ FI) /*const*//* = 0*/;

  
  /// EmitVAArg - Emit the target dependent code to load a value of
  /// \arg Ty from the va_list pointed to by \arg VAListAddr.
  
  // FIXME: This is a gaping layering violation if we wanted to drop
  // the ABI information any lower than CodeGen. Of course, for
  // VAArg handling it has to be at this level; there is no way to
  // abstract this out.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::EmitVAArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ABIInfo.h", line = 91,
   FQN="clang::CodeGen::ABIInfo::EmitVAArg", NM="_ZNK5clang7CodeGen7ABIInfo9EmitVAArgERNS0_15CodeGenFunctionENS0_7AddressENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen7ABIInfo9EmitVAArgERNS0_15CodeGenFunctionENS0_7AddressENS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ Address EmitVAArg(final CodeGenFunction /*&*/ CGF, 
           Address VAListAddr, 
           QualType Ty) /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::isAndroid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 161,
   FQN="clang::CodeGen::ABIInfo::isAndroid", NM="_ZNK5clang7CodeGen7ABIInfo9isAndroidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen7ABIInfo9isAndroidEv")
  //</editor-fold>
  public boolean isAndroid() /*const*/ {
    return getTarget().getTriple().isAndroid();
  }

  
  /// Emit the target dependent code to load a value of
  /// \arg Ty from the \c __builtin_ms_va_list pointed to by \arg VAListAddr.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::EmitMSVAArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 65,
   FQN="clang::CodeGen::ABIInfo::EmitMSVAArg", NM="_ZNK5clang7CodeGen7ABIInfo11EmitMSVAArgERNS0_15CodeGenFunctionENS0_7AddressENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen7ABIInfo11EmitMSVAArgERNS0_15CodeGenFunctionENS0_7AddressENS_8QualTypeE")
  //</editor-fold>
  public Address EmitMSVAArg(final CodeGenFunction /*&*/ CGF, Address VAListAddr, 
             QualType Ty) /*const*/ {
    return Address.invalid();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::isHomogeneousAggregateBaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 163,
   FQN="clang::CodeGen::ABIInfo::isHomogeneousAggregateBaseType", NM="_ZNK5clang7CodeGen7ABIInfo30isHomogeneousAggregateBaseTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen7ABIInfo30isHomogeneousAggregateBaseTypeENS_8QualTypeE")
  //</editor-fold>
  public boolean isHomogeneousAggregateBaseType(QualType Ty) /*const*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::isHomogeneousAggregateSmallEnough">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 167,
   FQN="clang::CodeGen::ABIInfo::isHomogeneousAggregateSmallEnough", NM="_ZNK5clang7CodeGen7ABIInfo33isHomogeneousAggregateSmallEnoughEPKNS_4TypeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen7ABIInfo33isHomogeneousAggregateSmallEnoughEPKNS_4TypeEy")
  //</editor-fold>
  public boolean isHomogeneousAggregateSmallEnough(/*const*/ Type /*P*/ Base, 
                                   long/*uint64_t*/ Members) /*const*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::shouldSignExtUnsignedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 172,
   FQN="clang::CodeGen::ABIInfo::shouldSignExtUnsignedType", NM="_ZNK5clang7CodeGen7ABIInfo25shouldSignExtUnsignedTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen7ABIInfo25shouldSignExtUnsignedTypeENS_8QualTypeE")
  //</editor-fold>
  public boolean shouldSignExtUnsignedType(QualType Ty) /*const*/ {
    return false;
  }

  
  
  /// isHomogeneousAggregate - Return true if a type is an ELFv2 homogeneous
  /// aggregate.  Base is set to the base element type, and Members is set
  /// to the number of base elements.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::isHomogeneousAggregate">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4055,
   FQN="clang::CodeGen::ABIInfo::isHomogeneousAggregate", NM="_ZNK5clang7CodeGen7ABIInfo22isHomogeneousAggregateENS_8QualTypeERPKNS_4TypeERy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen7ABIInfo22isHomogeneousAggregateENS_8QualTypeERPKNS_4TypeERy")
  //</editor-fold>
  public boolean isHomogeneousAggregate(QualType Ty, final type$ref</*const*/ Type /*P*/ /*&*/> Base, 
                        final ulong$ref/*uint64_t &*/ Members) /*const*/ {
    {
      /*const*/ ConstantArrayType /*P*/ AT = getContext().getAsConstantArrayType(new QualType(Ty));
      if ((AT != null)) {
        long/*uint64_t*/ NElements = AT.getSize().getZExtValue();
        if (NElements == $int2ullong(0)) {
          return false;
        }
        if (!isHomogeneousAggregate(AT.getElementType(), Base, Members)) {
          return false;
        }
        Members.$set$starassign(NElements);
      } else {
        /*const*/ RecordType /*P*/ RT = Ty.$arrow().getAs$RecordType();
        if ((RT != null)) {
          /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
          if (RD.hasFlexibleArrayMember()) {
            return false;
          }
          
          Members.$set($int2ulong(0));
          {
            
            // If this is a C++ record, check the bases first.
            /*const*/ CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(RD);
            if ((CXXRD != null)) {
              for (final /*const*/ CXXBaseSpecifier /*&*/ I : CXXRD.bases$Const()) {
                // Ignore empty records.
                if (isEmptyRecord(getContext(), I.getType(), true)) {
                  continue;
                }
                
                ulong$ref FldMembers = create_ulong$ref(0);
                if (!isHomogeneousAggregate(I.getType(), Base, FldMembers)) {
                  return false;
                }
                
                Members.$set$addassign(FldMembers.$deref());
              }
            }
          }
          
          for (/*const*/ FieldDecl /*P*/ FD : RD.fields()) {
            // Ignore (non-zero arrays of) empty records.
            QualType FT = FD.getType();
            {
              /*const*/ ConstantArrayType /*P*/ AT$1;
              while (((/*P*/ AT$1 = getContext().getAsConstantArrayType(new QualType(FT))) != null)) {
                if (AT$1.getSize().getZExtValue() == $int2ullong(0)) {
                  return false;
                }
                FT.$assignMove(AT$1.getElementType());
              }
            }
            if (isEmptyRecord(getContext(), new QualType(FT), true)) {
              continue;
            }
            
            // For compatibility with GCC, ignore empty bitfields in C++ mode.
            if (getContext().getLangOpts().CPlusPlus
               && FD.isBitField() && FD.getBitWidthValue(getContext()) == 0) {
              continue;
            }
            
            ulong$ref FldMembers = create_ulong$ref(0);
            if (!isHomogeneousAggregate(FD.getType(), Base, FldMembers)) {
              return false;
            }
            
            Members.$set((RD.isUnion() ? std.max(Members.$deref(), FldMembers.$deref()) : Members.$deref() + FldMembers.$deref()));
          }
          if (!(Base.$deref() != null)) {
            return false;
          }
          
          // Ensure there is no padding.
          if (getContext().getTypeSize(Base.$deref()) * Members.$deref()
             != getContext().getTypeSize(new QualType(Ty))) {
            return false;
          }
        } else {
          Members.$set($int2ulong(1));
          {
            /*const*/ ComplexType /*P*/ CT = Ty.$arrow().getAs(ComplexType.class);
            if ((CT != null)) {
              Members.$set($int2ulong(2));
              Ty.$assignMove(CT.getElementType());
            }
          }
          
          // Most ABIs only support float, double, and some vector type widths.
          if (!isHomogeneousAggregateBaseType(new QualType(Ty))) {
            return false;
          }
          
          // The base type must be the same for all members.  Types that
          // agree in both total size and mode (float vs. vector) are
          // treated as being equivalent here.
          /*const*/ Type /*P*/ TyPtr = Ty.getTypePtr();
          if (!(Base.$deref() != null)) {
            Base.$set(TyPtr);
            {
              // If it's a non-power-of-2 vector, its size is already a power-of-2,
              // so make sure to widen it explicitly.
              /*const*/ VectorType /*P*/ VT = Base.$deref().getAs(VectorType.class);
              if ((VT != null)) {
                QualType EltTy = VT.getElementType();
                /*uint*/int NumElements = $ullong2uint($div_ulong(getContext().getTypeSize(VT), getContext().getTypeSize(new QualType(EltTy))));
                Base.$set(getContext().
                    getVectorType(new QualType(EltTy), NumElements, VT.getVectorKind()).
                    getTypePtr());
              }
            }
          }
          if (Base.$deref().isVectorType() != TyPtr.isVectorType()
             || getContext().getTypeSize(Base.$deref()) != getContext().getTypeSize(TyPtr)) {
            return false;
          }
        }
      }
    }
    return $greater_ulong_ullong(Members.$deref(), $int2ullong(0)) && isHomogeneousAggregateSmallEnough(Base.$deref(), Members.$deref());
  }

  
  /// A convenience method to return an indirect ABIArgInfo with an
  /// expected alignment equal to the ABI alignment of the given type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::getNaturalAlignIndirect">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 52,
   FQN="clang::CodeGen::ABIInfo::getNaturalAlignIndirect", NM="_ZNK5clang7CodeGen7ABIInfo23getNaturalAlignIndirectENS_8QualTypeEbbPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen7ABIInfo23getNaturalAlignIndirectENS_8QualTypeEbbPN4llvm4TypeE")
  //</editor-fold>
  public ABIArgInfo getNaturalAlignIndirect(QualType Ty) /*const*/ {
    return getNaturalAlignIndirect(Ty, true, false, 
                         (org.llvm.ir.Type /*P*/ )null);
  }
  public ABIArgInfo getNaturalAlignIndirect(QualType Ty, boolean ByRef/*= true*/) /*const*/ {
    return getNaturalAlignIndirect(Ty, ByRef, false, 
                         (org.llvm.ir.Type /*P*/ )null);
  }
  public ABIArgInfo getNaturalAlignIndirect(QualType Ty, boolean ByRef/*= true*/, boolean Realign/*= false*/) /*const*/ {
    return getNaturalAlignIndirect(Ty, ByRef, Realign, 
                         (org.llvm.ir.Type /*P*/ )null);
  }
  public ABIArgInfo getNaturalAlignIndirect(QualType Ty, boolean ByRef/*= true*/, boolean Realign/*= false*/, 
                         org.llvm.ir.Type /*P*/ Padding/*= null*/) /*const*/ {
    return ABIArgInfo.getIndirect(getContext().getTypeAlignInChars(new QualType(Ty)), 
        ByRef, Realign, Padding);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ABIInfo::getNaturalAlignIndirectInReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 59,
   FQN="clang::CodeGen::ABIInfo::getNaturalAlignIndirectInReg", NM="_ZNK5clang7CodeGen7ABIInfo28getNaturalAlignIndirectInRegENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen7ABIInfo28getNaturalAlignIndirectInRegENS_8QualTypeEb")
  //</editor-fold>
  public ABIArgInfo getNaturalAlignIndirectInReg(QualType Ty) /*const*/ {
    return getNaturalAlignIndirectInReg(Ty, false);
  }
  public ABIArgInfo getNaturalAlignIndirectInReg(QualType Ty, boolean Realign/*= false*/) /*const*/ {
    return ABIArgInfo.getIndirectInReg(getContext().getTypeAlignInChars(new QualType(Ty)), 
        /*ByRef*/ false, Realign);
  }

  
  @Override public String toString() {
    return "" + "CGT=" + CGT // NOI18N
              + ", RuntimeCC=" + RuntimeCC // NOI18N
              + ", BuiltinCC=" + BuiltinCC; // NOI18N
  }
}

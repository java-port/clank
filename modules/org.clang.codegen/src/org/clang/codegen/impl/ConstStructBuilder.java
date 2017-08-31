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

package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.ast.DeclContext.specific_decl_iterator;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstStructBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 37,
 FQN="(anonymous namespace)::ConstStructBuilder", NM="_ZN12_GLOBAL__N_118ConstStructBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ConstStructBuilderE")
//</editor-fold>
public class ConstStructBuilder implements Destructors.ClassWithDestructor {
  private final CodeGenModule /*&*/ CGM;
  private CodeGenFunction /*P*/ CGF;
  
  private boolean Packed;
  private CharUnits NextFieldOffsetInChars;
  private CharUnits LLVMStructAlignment;
  private SmallVector<Constant /*P*/ > Elements;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstStructBuilder::BuildStruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 561,
   FQN="(anonymous namespace)::ConstStructBuilder::BuildStruct", NM="_ZN12_GLOBAL__N_118ConstStructBuilder11BuildStructERN5clang7CodeGen13CodeGenModuleEPNS2_15CodeGenFunctionEPNS_16ConstExprEmitterEPN4llvm14ConstantStructEPNS1_12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ConstStructBuilder11BuildStructERN5clang7CodeGen13CodeGenModuleEPNS2_15CodeGenFunctionEPNS_16ConstExprEmitterEPN4llvm14ConstantStructEPNS1_12InitListExprE")
  //</editor-fold>
  public static Constant /*P*/ BuildStruct(final CodeGenModule /*&*/ CGM, 
             CodeGenFunction /*P*/ CGF, 
             ConstExprEmitter /*P*/ Emitter, 
             ConstantStruct /*P*/ Base, 
             InitListExpr /*P*/ Updater) {
    ConstStructBuilder Builder = null;
    try {
      Builder/*J*/= new ConstStructBuilder(CGM, CGF);
      if (!Builder.Build(Emitter, Base, Updater)) {
        return null;
      }
      return Builder.Finalize(Updater.getType());
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstStructBuilder::BuildStruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 572,
   FQN="(anonymous namespace)::ConstStructBuilder::BuildStruct", NM="_ZN12_GLOBAL__N_118ConstStructBuilder11BuildStructERN5clang7CodeGen13CodeGenModuleEPNS2_15CodeGenFunctionEPNS1_12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ConstStructBuilder11BuildStructERN5clang7CodeGen13CodeGenModuleEPNS2_15CodeGenFunctionEPNS1_12InitListExprE")
  //</editor-fold>
  public static Constant /*P*/ BuildStruct(final CodeGenModule /*&*/ CGM, 
             CodeGenFunction /*P*/ CGF, 
             InitListExpr /*P*/ ILE) {
    ConstStructBuilder Builder = null;
    try {
      Builder/*J*/= new ConstStructBuilder(CGM, CGF);
      if (!Builder.Build(ILE)) {
        return null;
      }
      
      return Builder.Finalize(ILE.getType());
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstStructBuilder::BuildStruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 583,
   FQN="(anonymous namespace)::ConstStructBuilder::BuildStruct", NM="_ZN12_GLOBAL__N_118ConstStructBuilder11BuildStructERN5clang7CodeGen13CodeGenModuleEPNS2_15CodeGenFunctionERKNS1_7APValueENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ConstStructBuilder11BuildStructERN5clang7CodeGen13CodeGenModuleEPNS2_15CodeGenFunctionERKNS1_7APValueENS1_8QualTypeE")
  //</editor-fold>
  public static Constant /*P*/ BuildStruct(final CodeGenModule /*&*/ CGM, 
             CodeGenFunction /*P*/ CGF, 
             final /*const*/ APValue /*&*/ Val, 
             QualType ValTy) {
    ConstStructBuilder Builder = null;
    try {
      Builder/*J*/= new ConstStructBuilder(CGM, CGF);
      
      /*const*/ RecordDecl /*P*/ RD = ValTy.$arrow().castAs$RecordType().getDecl();
      /*const*/ CXXRecordDecl /*P*/ CD = dyn_cast_CXXRecordDecl(RD);
      Builder.Build(Val, RD, false, CD, CharUnits.Zero());
      
      return Builder.Finalize(new QualType(ValTy));
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstStructBuilder::ConstStructBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 56,
   FQN="(anonymous namespace)::ConstStructBuilder::ConstStructBuilder", NM="_ZN12_GLOBAL__N_118ConstStructBuilderC1ERN5clang7CodeGen13CodeGenModuleEPNS2_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ConstStructBuilderC1ERN5clang7CodeGen13CodeGenModuleEPNS2_15CodeGenFunctionE")
  //</editor-fold>
  private ConstStructBuilder(final CodeGenModule /*&*/ CGM, CodeGenFunction /*P*/ CGF) {
    // : CGM(CGM), CGF(CGF), Packed(false), NextFieldOffsetInChars(CharUnits::Zero()), LLVMStructAlignment(CharUnits::One()), Elements() 
    //START JInit
    this./*&*/CGM=/*&*/CGM;
    this.CGF = CGF;
    this.Packed = false;
    this.NextFieldOffsetInChars = CharUnits.Zero();
    this.LLVMStructAlignment = CharUnits.One();
    this.Elements = new SmallVector<Constant /*P*/ >(32, (Constant /*P*/ )null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstStructBuilder::AppendField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 94,
   FQN="(anonymous namespace)::ConstStructBuilder::AppendField", NM="_ZN12_GLOBAL__N_118ConstStructBuilder11AppendFieldEPKN5clang9FieldDeclEyPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ConstStructBuilder11AppendFieldEPKN5clang9FieldDeclEyPN4llvm8ConstantE")
  //</editor-fold>
  private void AppendField(/*const*/ FieldDecl /*P*/ Field, long/*uint64_t*/ FieldOffset, 
             Constant /*P*/ InitCst) {
    final /*const*/ ASTContext /*&*/ Context = CGM.getContext();
    
    CharUnits FieldOffsetInChars = Context.toCharUnitsFromBits(FieldOffset);
    
    AppendBytes(new CharUnits(FieldOffsetInChars), InitCst);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstStructBuilder::AppendBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 104,
   FQN="(anonymous namespace)::ConstStructBuilder::AppendBytes", NM="_ZN12_GLOBAL__N_118ConstStructBuilder11AppendBytesEN5clang9CharUnitsEPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ConstStructBuilder11AppendBytesEN5clang9CharUnitsEPN4llvm8ConstantE")
  //</editor-fold>
  private void AppendBytes(CharUnits FieldOffsetInChars, Constant /*P*/ InitCst) {
    assert (NextFieldOffsetInChars.$lesseq(FieldOffsetInChars)) : "Field offset mismatch!";
    
    CharUnits FieldAlignment = getAlignment(InitCst);
    
    // Round up the field offset to the alignment of the field type.
    CharUnits AlignedNextFieldOffsetInChars = NextFieldOffsetInChars.alignTo(FieldAlignment);
    if (AlignedNextFieldOffsetInChars.$less(FieldOffsetInChars)) {
      // We need to append padding.
      AppendPadding(FieldOffsetInChars.$sub(NextFieldOffsetInChars));
      assert (NextFieldOffsetInChars.$eq(FieldOffsetInChars)) : "Did not add enough padding!";
      
      AlignedNextFieldOffsetInChars.$assignMove(
          NextFieldOffsetInChars.alignTo(FieldAlignment)
      );
    }
    if (AlignedNextFieldOffsetInChars.$greater(FieldOffsetInChars)) {
      assert (!Packed) : "Alignment is wrong even with a packed struct!";
      
      // Convert the struct to a packed struct.
      ConvertStructToPacked();
      
      // After we pack the struct, we may need to insert padding.
      if (NextFieldOffsetInChars.$less(FieldOffsetInChars)) {
        // We need to append padding.
        AppendPadding(FieldOffsetInChars.$sub(NextFieldOffsetInChars));
        assert (NextFieldOffsetInChars.$eq(FieldOffsetInChars)) : "Did not add enough padding!";
      }
      AlignedNextFieldOffsetInChars.$assign(NextFieldOffsetInChars);
    }
    
    // Add the field.
    Elements.push_back(InitCst);
    NextFieldOffsetInChars.$assignMove(AlignedNextFieldOffsetInChars.$add(
            getSizeInChars(InitCst)
        ));
    if (Packed) {
      assert (LLVMStructAlignment.$eq(CharUnits.One())) : "Packed struct not byte-aligned!";
    } else {
      LLVMStructAlignment.$assign(std.max(LLVMStructAlignment, FieldAlignment));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstStructBuilder::AppendBitField">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 156,
   FQN="(anonymous namespace)::ConstStructBuilder::AppendBitField", NM="_ZN12_GLOBAL__N_118ConstStructBuilder14AppendBitFieldEPKN5clang9FieldDeclEyPN4llvm11ConstantIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ConstStructBuilder14AppendBitFieldEPKN5clang9FieldDeclEyPN4llvm11ConstantIntE")
  //</editor-fold>
  private void AppendBitField(/*const*/ FieldDecl /*P*/ Field, 
                long/*uint64_t*/ FieldOffset, 
                ConstantInt /*P*/ CI) {
    final /*const*/ ASTContext /*&*/ Context = CGM.getContext();
    /*const*/long/*uint64_t*/ CharWidth = Context.getCharWidth();
    long/*uint64_t*/ NextFieldOffsetInBits = Context.toBits(new CharUnits(NextFieldOffsetInChars));
    if ($greater_ulong(FieldOffset, NextFieldOffsetInBits)) {
      // We need to add padding.
      CharUnits PadSize = Context.toCharUnitsFromBits(llvm.alignTo(FieldOffset - NextFieldOffsetInBits, 
              $uint2ulong(Context.getTargetInfo().getCharAlign())));
      
      AppendPadding(new CharUnits(PadSize));
    }
    
    long/*uint64_t*/ FieldSize = $uint2ulong(Field.getBitWidthValue(Context));
    
    APInt FieldValue = new APInt(CI.getValue());
    
    // Promote the size of FieldValue if necessary
    // FIXME: This should never occur, but currently it can because initializer
    // constants are cast to bool, and because clang is not enforcing bitfield
    // width limits.
    if ($greater_ulong_uint(FieldSize, FieldValue.getBitWidth())) {
      FieldValue.$assignMove(FieldValue.zext($ulong2uint(FieldSize)));
    }
    
    // Truncate the size of FieldValue to the bit field size.
    if ($less_ulong_uint(FieldSize, FieldValue.getBitWidth())) {
      FieldValue.$assignMove(FieldValue.trunc($ulong2uint(FieldSize)));
    }
    
    NextFieldOffsetInBits = Context.toBits(new CharUnits(NextFieldOffsetInChars));
    if ($less_ulong(FieldOffset, NextFieldOffsetInBits)) {
      // Either part of the field or the entire field can go into the previous
      // byte.
      assert (!Elements.empty()) : "Elements can't be empty!";
      
      /*uint*/int BitsInPreviousByte = $ullong2uint(NextFieldOffsetInBits - FieldOffset);
      
      boolean FitsCompletelyInPreviousByte = $greatereq_uint(BitsInPreviousByte, FieldValue.getBitWidth());
      
      APInt Tmp = new APInt(FieldValue);
      if (!FitsCompletelyInPreviousByte) {
        /*uint*/int NewFieldWidth = $ullong2uint(FieldSize - $uint2ullong(BitsInPreviousByte));
        if (CGM.getDataLayout().isBigEndian()) {
          Tmp.$assignMove(Tmp.lshr(NewFieldWidth));
          Tmp.$assignMove(Tmp.trunc(BitsInPreviousByte));
          
          // We want the remaining high bits.
          FieldValue.$assignMove(FieldValue.trunc(NewFieldWidth));
        } else {
          Tmp.$assignMove(Tmp.trunc(BitsInPreviousByte));
          
          // We want the remaining low bits.
          FieldValue.$assignMove(FieldValue.lshr(BitsInPreviousByte));
          FieldValue.$assignMove(FieldValue.trunc(NewFieldWidth));
        }
      }
      
      Tmp.$assignMove(Tmp.zext($ulong2uint(CharWidth)));
      if (CGM.getDataLayout().isBigEndian()) {
        if (FitsCompletelyInPreviousByte) {
          Tmp.$assignMove(Tmp.shl(BitsInPreviousByte - FieldValue.getBitWidth()));
        }
      } else {
        Tmp.$assignMove(Tmp.shl($ullong2uint(CharWidth - $uint2ullong(BitsInPreviousByte))));
      }
      
      // 'or' in the bits that go into the previous byte.
      Value /*P*/ LastElt = Elements.back();
      {
        ConstantInt /*P*/ Val = dyn_cast_ConstantInt(LastElt);
        if ((Val != null)) {
          Tmp.$orassign(Val.getValue());
        } else {
          assert (isa_UndefValue(LastElt));
          // If there is an undef field that we're adding to, it can either be a
          // scalar undef (in which case, we just replace it with our field) or it
          // is an array.  If it is an array, we have to pull one byte off the
          // array so that the other undef bytes stay around.
          if (!isa_IntegerType(LastElt.getType())) {
            // The undef padding will be a multibyte array, create a new smaller
            // padding and then an hole for our i8 to get plopped into.
            assert (isa_ArrayType(LastElt.getType())) : "Expected array padding of undefs";
            org.llvm.ir.ArrayType /*P*/ AT = cast_ArrayType(LastElt.getType());
            assert (AT.getElementType().isIntegerTy($ulong2uint(CharWidth)) && AT.getNumElements() != $int2ullong(0)) : "Expected non-empty array padding of undefs";
            
            // Remove the padding array.
            NextFieldOffsetInChars.$minusassign(CharUnits.fromQuantity(AT.getNumElements()));
            Elements.pop_back();
            
            // Add the padding back in two chunks.
            AppendPadding(CharUnits.fromQuantity(AT.getNumElements() - $int2ullong(1)));
            AppendPadding(CharUnits.One());
            assert (isa_UndefValue(Elements.back()) && Elements.back().getType().isIntegerTy($ulong2uint(CharWidth))) : "Padding addition didn't work right";
          }
        }
      }
      
      Elements.ref$back().$set(ConstantInt.get(CGM.getLLVMContext(), Tmp));
      if (FitsCompletelyInPreviousByte) {
        return;
      }
    }
    while ($greater_uint_ulong(FieldValue.getBitWidth(), CharWidth)) {
      APInt Tmp/*J*/= new APInt();
      if (CGM.getDataLayout().isBigEndian()) {
        // We want the high bits.
        Tmp.$assignMove(
            FieldValue.lshr($ullong2uint($uint2ullong(FieldValue.getBitWidth()) - CharWidth)).trunc($ulong2uint(CharWidth))
        );
      } else {
        // We want the low bits.
        Tmp.$assignMove(FieldValue.trunc($ulong2uint(CharWidth)));
        
        FieldValue.$assignMove(FieldValue.lshr($ulong2uint(CharWidth)));
      }
      
      Elements.push_back(ConstantInt.get(CGM.getLLVMContext(), Tmp));
      NextFieldOffsetInChars.$preInc();
      
      FieldValue.$assignMove(FieldValue.trunc($ullong2uint($uint2ullong(FieldValue.getBitWidth()) - CharWidth)));
    }
    assert ($greater_uint(FieldValue.getBitWidth(), 0)) : "Should have at least one bit left!";
    assert ($lesseq_uint_ulong(FieldValue.getBitWidth(), CharWidth)) : "Should not have more than a byte left!";
    if ($less_uint_ulong(FieldValue.getBitWidth(), CharWidth)) {
      if (CGM.getDataLayout().isBigEndian()) {
        /*uint*/int BitWidth = FieldValue.getBitWidth();
        
        FieldValue.$assignMove(FieldValue.zext($ulong2uint(CharWidth)).$out($ullong2uint((CharWidth - $uint2ullong(BitWidth)))));
      } else {
        FieldValue.$assignMove(FieldValue.zext($ulong2uint(CharWidth)));
      }
    }
    
    // Append the last element.
    Elements.push_back(ConstantInt.get(CGM.getLLVMContext(), 
            FieldValue));
    NextFieldOffsetInChars.$preInc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstStructBuilder::AppendPadding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 304,
   FQN="(anonymous namespace)::ConstStructBuilder::AppendPadding", NM="_ZN12_GLOBAL__N_118ConstStructBuilder13AppendPaddingEN5clang9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ConstStructBuilder13AppendPaddingEN5clang9CharUnitsE")
  //</editor-fold>
  private void AppendPadding(CharUnits PadSize) {
    if (PadSize.isZero()) {
      return;
    }
    
    org.llvm.ir.Type /*P*/ Ty = CGM.Int8Ty;
    if (PadSize.$greater(CharUnits.One())) {
      Ty = org.llvm.ir.ArrayType.get(Ty, PadSize.getQuantity());
    }
    
    Constant /*P*/ C = UndefValue.get(Ty);
    Elements.push_back(C);
    assert (getAlignment(C).$eq(CharUnits.One())) : "Padding must have 1 byte alignment!";
    
    NextFieldOffsetInChars.$addassign(getSizeInChars(C));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstStructBuilder::AppendTailPadding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 320,
   FQN="(anonymous namespace)::ConstStructBuilder::AppendTailPadding", NM="_ZN12_GLOBAL__N_118ConstStructBuilder17AppendTailPaddingEN5clang9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ConstStructBuilder17AppendTailPaddingEN5clang9CharUnitsE")
  //</editor-fold>
  private void AppendTailPadding(CharUnits RecordSize) {
    assert (NextFieldOffsetInChars.$lesseq(RecordSize)) : "Size mismatch!";
    
    AppendPadding(RecordSize.$sub(NextFieldOffsetInChars));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstStructBuilder::ConvertStructToPacked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 327,
   FQN="(anonymous namespace)::ConstStructBuilder::ConvertStructToPacked", NM="_ZN12_GLOBAL__N_118ConstStructBuilder21ConvertStructToPackedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ConstStructBuilder21ConvertStructToPackedEv")
  //</editor-fold>
  private void ConvertStructToPacked() {
    SmallVector<Constant /*P*/ > PackedElements/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
    CharUnits ElementOffsetInChars = CharUnits.Zero();
    
    for (/*uint*/int i = 0, e = Elements.size(); i != e; ++i) {
      Constant /*P*/ C = Elements.$at(i);
      
      CharUnits ElementAlign = CharUnits.fromQuantity($uint2long(CGM.getDataLayout().getABITypeAlignment(C.getType())));
      CharUnits AlignedElementOffsetInChars = ElementOffsetInChars.alignTo(ElementAlign);
      if (AlignedElementOffsetInChars.$greater(ElementOffsetInChars)) {
        // We need some padding.
        CharUnits NumChars = AlignedElementOffsetInChars.$sub(ElementOffsetInChars);
        
        org.llvm.ir.Type /*P*/ Ty = CGM.Int8Ty;
        if (NumChars.$greater(CharUnits.One())) {
          Ty = org.llvm.ir.ArrayType.get(Ty, NumChars.getQuantity());
        }
        
        Constant /*P*/ Padding = UndefValue.get(Ty);
        PackedElements.push_back(Padding);
        ElementOffsetInChars.$addassign(getSizeInChars(Padding));
      }
      
      PackedElements.push_back(C);
      ElementOffsetInChars.$addassign(getSizeInChars(C));
    }
    assert (ElementOffsetInChars.$eq(NextFieldOffsetInChars)) : "Packing the struct changed its size!";
    
    Elements.swap(PackedElements);
    LLVMStructAlignment.$assignMove(CharUnits.One());
    Packed = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstStructBuilder::Build">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 365,
   FQN="(anonymous namespace)::ConstStructBuilder::Build", NM="_ZN12_GLOBAL__N_118ConstStructBuilder5BuildEPN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ConstStructBuilder5BuildEPN5clang12InitListExprE")
  //</editor-fold>
  private boolean Build(InitListExpr /*P*/ ILE) {
    RecordDecl /*P*/ RD = ILE.getType().$arrow().getAs$RecordType().getDecl();
    final /*const*/ ASTRecordLayout /*&*/ Layout = CGM.getContext().getASTRecordLayout(RD);
    
    /*uint*/int FieldNo = 0;
    /*uint*/int ElementNo = 0;
    {
      
      // Bail out if we have base classes. We could support these, but they only
      // arise in C++1z where we will have already constant folded most interesting
      // cases. FIXME: There are still a few more cases we can handle this way.
      CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(RD);
      if ((CXXRD != null)) {
        if ((CXXRD.getNumBases() != 0)) {
          return false;
        }
      }
    }
    
    for (DeclContext.specific_decl_iterator<FieldDecl> Field = RD.field_begin(), 
        FieldEnd = RD.field_end(); specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd); Field.$preInc() , ++FieldNo) {
      // If this is a union, skip all the fields that aren't being initialized.
      if (RD.isUnion() && ILE.getInitializedFieldInUnion() != Field.$star()) {
        continue;
      }
      
      // Don't emit anonymous bitfields, they just affect layout.
      if (Field.$arrow().isUnnamedBitfield()) {
        continue;
      }
      
      // Get the initializer.  A struct can include fields without initializers,
      // we just use explicit null values for them.
      Constant /*P*/ EltInit;
      if ($less_uint(ElementNo, ILE.getNumInits())) {
        EltInit = CGM.EmitConstantExpr(ILE.getInit(ElementNo++), 
            Field.$arrow().getType(), CGF);
      } else {
        EltInit = CGM.EmitNullConstant(Field.$arrow().getType());
      }
      if (!(EltInit != null)) {
        return false;
      }
      if (!Field.$arrow().isBitField()) {
        // Handle non-bitfield members.
        AppendField(Field.$star(), Layout.getFieldOffset(FieldNo), EltInit);
      } else {
        {
          // Otherwise we have a bitfield.
          ConstantInt /*P*/ CI = dyn_cast_ConstantInt(EltInit);
          if ((CI != null)) {
            AppendBitField(Field.$star(), Layout.getFieldOffset(FieldNo), CI);
          } else {
            // We are trying to initialize a bitfield with a non-trivial constant,
            // this must require run-time code.
            return false;
          }
        }
      }
    }
    
    return true;
  }

  // end anonymous namespace.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstStructBuilder::Build">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 1127,
   FQN="(anonymous namespace)::ConstStructBuilder::Build", NM="_ZN12_GLOBAL__N_118ConstStructBuilder5BuildEPNS_16ConstExprEmitterEPN4llvm14ConstantStructEPN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ConstStructBuilder5BuildEPNS_16ConstExprEmitterEPN4llvm14ConstantStructEPN5clang12InitListExprE")
  //</editor-fold>
  private boolean Build(ConstExprEmitter /*P*/ Emitter, 
       ConstantStruct /*P*/ Base, 
       InitListExpr /*P*/ Updater) {
    assert ((Base != null)) : "base expression should not be empty";
    
    QualType ExprType = Updater.getType();
    RecordDecl /*P*/ RD = ExprType.$arrow().getAs$RecordType().getDecl();
    final /*const*/ ASTRecordLayout /*&*/ Layout = CGM.getContext().getASTRecordLayout(RD);
    /*const*/ StructLayout /*P*/ BaseLayout = CGM.getDataLayout().getStructLayout(Base.getType());
    /*uint*/int FieldNo = -1;
    /*uint*/int ElementNo = 0;
    {
      
      // Bail out if we have base classes. We could support these, but they only
      // arise in C++1z where we will have already constant folded most interesting
      // cases. FIXME: There are still a few more cases we can handle this way.
      CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(RD);
      if ((CXXRD != null)) {
        if ((CXXRD.getNumBases() != 0)) {
          return false;
        }
      }
    }
    
    for (FieldDecl /*P*/ Field : RD.fields()) {
      ++FieldNo;
      if (RD.isUnion() && Updater.getInitializedFieldInUnion() != Field) {
        continue;
      }
      
      // Skip anonymous bitfields.
      if (Field.isUnnamedBitfield()) {
        continue;
      }
      
      Constant /*P*/ EltInit = Base.getOperand(ElementNo);
      
      // Bail out if the type of the ConstantStruct does not have the same layout
      // as the type of the InitListExpr.
      if (CGM.getTypes().ConvertType(Field.getType()) != EltInit.getType()
         || Layout.getFieldOffset(ElementNo)
         != BaseLayout.getElementOffsetInBits(ElementNo)) {
        return false;
      }
      
      // Get the initializer. If we encounter an empty field or a NoInitExpr,
      // we use values from the base expression.
      Expr /*P*/ Init = null;
      if ($less_uint(ElementNo, Updater.getNumInits())) {
        Init = Updater.getInit(ElementNo);
      }
      if (!(Init != null) || isa_NoInitExpr(Init)) {
        ; // Do nothing.
      } else {
        InitListExpr /*P*/ ChildILE = dyn_cast_InitListExpr(Init);
        if ((ChildILE != null)) {
          EltInit = Emitter.EmitDesignatedInitUpdater(EltInit, ChildILE);
        } else {
          EltInit = CGM.EmitConstantExpr(Init, Field.getType(), CGF);
        }
      }
      
      ++ElementNo;
      if (!(EltInit != null)) {
        return false;
      }
      if (!Field.isBitField()) {
        AppendField(Field, Layout.getFieldOffset(FieldNo), EltInit);
      } else {
        ConstantInt /*P*/ CI = dyn_cast_ConstantInt(EltInit);
        if ((CI != null)) {
          AppendBitField(Field, Layout.getFieldOffset(FieldNo), CI);
        } else {
          // Initializing a bitfield with a non-trivial constant?
          return false;
        }
      }
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstStructBuilder::Build">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 433,
   FQN="(anonymous namespace)::ConstStructBuilder::Build", NM="_ZN12_GLOBAL__N_118ConstStructBuilder5BuildERKN5clang7APValueEPKNS1_10RecordDeclEbPKNS1_13CXXRecordDeclENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ConstStructBuilder5BuildERKN5clang7APValueEPKNS1_10RecordDeclEbPKNS1_13CXXRecordDeclENS1_9CharUnitsE")
  //</editor-fold>
  private void Build(final /*const*/ APValue /*&*/ Val, /*const*/ RecordDecl /*P*/ RD, 
       boolean IsPrimaryBase, 
       /*const*/ CXXRecordDecl /*P*/ VTableClass, 
       CharUnits Offset) {
    final /*const*/ ASTRecordLayout /*&*/ Layout = CGM.getContext().getASTRecordLayout(RD);
    {
      
      /*const*/ CXXRecordDecl /*P*/ CD = dyn_cast_CXXRecordDecl(RD);
      if ((CD != null)) {
        // Add a vtable pointer, if we need one and it hasn't already been added.
        if (CD.isDynamicClass() && !IsPrimaryBase) {
          Constant /*P*/ VTableAddressPoint = CGM.getCXXABI().getVTableAddressPointForConstExpr(new BaseSubobject(CD, new CharUnits(Offset)), VTableClass);
          AppendBytes(new CharUnits(Offset), VTableAddressPoint);
        }
        
        // Accumulate and sort bases, in order to visit them in address order, which
        // may not be the same as declaration order.
        SmallVector<BaseInfo> Bases/*J*/= new SmallVector<BaseInfo>(8, new BaseInfo());
        Bases.reserve(CD.getNumBases());
        /*uint*/int BaseNo = 0;
        for (type$ptr</*const*/ CXXBaseSpecifier /*P*/ > Base = $tryClone(CD.bases_begin$Const()), 
            /*P*/ BaseEnd = $tryClone(CD.bases_end$Const()); $noteq_ptr(Base, BaseEnd); Base.$preInc() , ++BaseNo) {
          assert (!Base./*->*/$star().isVirtual()) : "should not have virtual bases here";
          /*const*/ CXXRecordDecl /*P*/ BD = Base./*->*/$star().getType().$arrow().getAsCXXRecordDecl();
          CharUnits BaseOffset = Layout.getBaseClassOffset(BD);
          Bases.push_back(new BaseInfo(BD, new CharUnits(BaseOffset), BaseNo));
        }
        std.stable_sort(Bases.begin(), Bases.end());
        
        for (/*uint*/int I = 0, N = Bases.size(); I != N; ++I) {
          final BaseInfo /*&*/ Base = Bases.$at(I);
          
          boolean IsPrimaryBase$1 = Layout.getPrimaryBase() == Base.Decl;
          Build(Val.getStructBase$Const(Base.Index), Base.Decl, IsPrimaryBase$1, 
              VTableClass, Offset.$add(Base.Offset));
        }
      }
    }
    
    /*uint*/int FieldNo = 0;
    long/*uint64_t*/ OffsetBits = CGM.getContext().toBits(new CharUnits(Offset));
    
    for (DeclContext.specific_decl_iterator<FieldDecl> Field = RD.field_begin(), 
        FieldEnd = RD.field_end(); specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd); Field.$preInc() , ++FieldNo) {
      // If this is a union, skip all the fields that aren't being initialized.
      if (RD.isUnion() && Val.getUnionField() != Field.$star()) {
        continue;
      }
      
      // Don't emit anonymous bitfields, they just affect layout.
      if (Field.$arrow().isUnnamedBitfield()) {
        continue;
      }
      
      // Emit the value of the initializer.
      final /*const*/ APValue /*&*/ FieldValue = RD.isUnion() ? Val.getUnionValue$Const() : Val.getStructField$Const(FieldNo);
      Constant /*P*/ EltInit = CGM.EmitConstantValueForMemory(FieldValue, Field.$arrow().getType(), CGF);
      assert ((EltInit != null)) : "EmitConstantValue can't fail";
      if (!Field.$arrow().isBitField()) {
        // Handle non-bitfield members.
        AppendField(Field.$star(), Layout.getFieldOffset(FieldNo) + OffsetBits, EltInit);
      } else {
        // Otherwise we have a bitfield.
        AppendBitField(Field.$star(), Layout.getFieldOffset(FieldNo) + OffsetBits, 
            cast_ConstantInt(EltInit));
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstStructBuilder::Finalize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 502,
   FQN="(anonymous namespace)::ConstStructBuilder::Finalize", NM="_ZN12_GLOBAL__N_118ConstStructBuilder8FinalizeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ConstStructBuilder8FinalizeEN5clang8QualTypeE")
  //</editor-fold>
  private Constant /*P*/ Finalize(QualType Ty) {
    RecordDecl /*P*/ RD = Ty.$arrow().getAs$RecordType().getDecl();
    final /*const*/ ASTRecordLayout /*&*/ Layout = CGM.getContext().getASTRecordLayout(RD);
    
    CharUnits LayoutSizeInChars = Layout.getSize();
    if (NextFieldOffsetInChars.$greater(LayoutSizeInChars)) {
      // If the struct is bigger than the size of the record type,
      // we must have a flexible array member at the end.
      assert (RD.hasFlexibleArrayMember()) : "Must have flexible array member if struct is bigger than type!";
      // No tail padding is necessary.
    } else {
      // Append tail padding if necessary.
      CharUnits LLVMSizeInChars = NextFieldOffsetInChars.alignTo(LLVMStructAlignment);
      if (LLVMSizeInChars.$noteq(LayoutSizeInChars)) {
        AppendTailPadding(new CharUnits(LayoutSizeInChars));
      }
      
      LLVMSizeInChars.$assignMove(NextFieldOffsetInChars.alignTo(LLVMStructAlignment));
      
      // Check if we need to convert the struct to a packed struct.
      if (NextFieldOffsetInChars.$lesseq(LayoutSizeInChars)
         && LLVMSizeInChars.$greater(LayoutSizeInChars)) {
        assert (!Packed) : "Size mismatch!";
        
        ConvertStructToPacked();
        assert (NextFieldOffsetInChars.$lesseq(LayoutSizeInChars)) : "Converting to packed did not help!";
      }
      
      LLVMSizeInChars.$assignMove(NextFieldOffsetInChars.alignTo(LLVMStructAlignment));
      assert (LayoutSizeInChars.$eq(LLVMSizeInChars)) : "Tail padding mismatch!";
    }
    
    // Pick the type to use.  If the type is layout identical to the ConvertType
    // type then use it, otherwise use whatever the builder produced for us.
    StructType /*P*/ STy = ConstantStruct.getTypeForElements(CGM.getLLVMContext(), 
        new ArrayRef<Constant /*P*/ >(Elements, true), Packed);
    org.llvm.ir.Type /*P*/ ValTy = CGM.getTypes().ConvertType(new QualType(Ty));
    {
      StructType /*P*/ ValSTy = dyn_cast_StructType(ValTy);
      if ((ValSTy != null)) {
        if (ValSTy.isLayoutIdentical(STy)) {
          STy = ValSTy;
        }
      }
    }
    
    Constant /*P*/ Result = ConstantStruct.get(STy, new ArrayRef<Constant /*P*/ >(Elements, true));
    assert (NextFieldOffsetInChars.alignTo(getAlignment(Result)).$eq(getSizeInChars(Result))) : "Size mismatch!";
    
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstStructBuilder::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 82,
   FQN="(anonymous namespace)::ConstStructBuilder::getAlignment", NM="_ZNK12_GLOBAL__N_118ConstStructBuilder12getAlignmentEPKN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZNK12_GLOBAL__N_118ConstStructBuilder12getAlignmentEPKN4llvm8ConstantE")
  //</editor-fold>
  private CharUnits getAlignment(/*const*/ Constant /*P*/ C) /*const*/ {
    if (Packed) {
      return CharUnits.One();
    }
    return CharUnits.fromQuantity($uint2long(CGM.getDataLayout().getABITypeAlignment(C.getType())));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstStructBuilder::getSizeInChars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 88,
   FQN="(anonymous namespace)::ConstStructBuilder::getSizeInChars", NM="_ZNK12_GLOBAL__N_118ConstStructBuilder14getSizeInCharsEPKN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZNK12_GLOBAL__N_118ConstStructBuilder14getSizeInCharsEPKN4llvm8ConstantE")
  //</editor-fold>
  private CharUnits getSizeInChars(/*const*/ Constant /*P*/ C) /*const*/ {
    return CharUnits.fromQuantity(CGM.getDataLayout().getTypeAllocSize(C.getType()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstStructBuilder::~ConstStructBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 37,
   FQN="(anonymous namespace)::ConstStructBuilder::~ConstStructBuilder", NM="_ZN12_GLOBAL__N_118ConstStructBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ConstStructBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Elements.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "CGM=" + CGM // NOI18N
              + ", CGF=" + CGF // NOI18N
              + ", Packed=" + Packed // NOI18N
              + ", NextFieldOffsetInChars=" + NextFieldOffsetInChars // NOI18N
              + ", LLVMStructAlignment=" + LLVMStructAlignment // NOI18N
              + ", Elements=" + Elements; // NOI18N
  }
}

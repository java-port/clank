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

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldMemcpyizer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 993,
 FQN="(anonymous namespace)::FieldMemcpyizer", NM="_ZN12_GLOBAL__N_115FieldMemcpyizerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_115FieldMemcpyizerE")
//</editor-fold>
public class FieldMemcpyizer {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldMemcpyizer::FieldMemcpyizer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 995,
   FQN="(anonymous namespace)::FieldMemcpyizer::FieldMemcpyizer", NM="_ZN12_GLOBAL__N_115FieldMemcpyizerC1ERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXRecordDeclEPKNS1_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_115FieldMemcpyizerC1ERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXRecordDeclEPKNS1_7VarDeclE")
  //</editor-fold>
  public FieldMemcpyizer(final CodeGenFunction /*&*/ CGF, /*const*/ CXXRecordDecl /*P*/ ClassDecl, 
      /*const*/ VarDecl /*P*/ SrcRec) {
    // : CGF(CGF), ClassDecl(ClassDecl), SrcRec(SrcRec), RecLayout(CGF.getContext().getASTRecordLayout(ClassDecl)), FirstField(null), LastField(null), FirstFieldOffset(0), LastFieldOffset(0), LastAddedFieldIndex(0) 
    //START JInit
    this./*&*/CGF=/*&*/CGF;
    this.ClassDecl = ClassDecl;
    this.SrcRec = SrcRec;
    this./*&*/RecLayout=/*&*/CGF.getContext().getASTRecordLayout(ClassDecl);
    this.FirstField = null;
    this.LastField = null;
    this.FirstFieldOffset = $int2ulong(0);
    this.LastFieldOffset = $int2ulong(0);
    this.LastAddedFieldIndex = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldMemcpyizer::isMemcpyableField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1002,
   FQN="(anonymous namespace)::FieldMemcpyizer::isMemcpyableField", NM="_ZNK12_GLOBAL__N_115FieldMemcpyizer17isMemcpyableFieldEPN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZNK12_GLOBAL__N_115FieldMemcpyizer17isMemcpyableFieldEPN5clang9FieldDeclE")
  //</editor-fold>
  public boolean isMemcpyableField(FieldDecl /*P*/ F) /*const*/ {
    // Never memcpy fields when we are adding poisoned paddings.
    if (($2bits_uint2uint(CGF.getContext().getLangOpts().SanitizeAddressFieldPadding) != 0)) {
      return false;
    }
    Qualifiers Qual = F.getType().getQualifiers();
    if (Qual.hasVolatile() || Qual.hasObjCLifetime()) {
      return false;
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldMemcpyizer::addMemcpyableField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1012,
   FQN="(anonymous namespace)::FieldMemcpyizer::addMemcpyableField", NM="_ZN12_GLOBAL__N_115FieldMemcpyizer18addMemcpyableFieldEPN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_115FieldMemcpyizer18addMemcpyableFieldEPN5clang9FieldDeclE")
  //</editor-fold>
  public void addMemcpyableField(FieldDecl /*P*/ F) {
    if (!(FirstField != null)) {
      addInitialField(F);
    } else {
      addNextField(F);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldMemcpyizer::getMemcpySize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1019,
   FQN="(anonymous namespace)::FieldMemcpyizer::getMemcpySize", NM="_ZNK12_GLOBAL__N_115FieldMemcpyizer13getMemcpySizeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZNK12_GLOBAL__N_115FieldMemcpyizer13getMemcpySizeEy")
  //</editor-fold>
  public CharUnits getMemcpySize(long/*uint64_t*/ FirstByteOffset) /*const*/ {
    /*uint*/int LastFieldSize = $ullong2uint(LastField.isBitField() ? $uint2ullong(LastField.getBitWidthValue(CGF.getContext())) : CGF.getContext().getTypeSize(LastField.getType()));
    long/*uint64_t*/ MemcpySizeBits = LastFieldOffset + $uint2ullong(LastFieldSize) - FirstByteOffset
       + CGF.getContext().getCharWidth() - $int2ullong(1);
    CharUnits MemcpySize = CGF.getContext().toCharUnitsFromBits(MemcpySizeBits);
    return MemcpySize;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldMemcpyizer::emitMemcpy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1032,
   FQN="(anonymous namespace)::FieldMemcpyizer::emitMemcpy", NM="_ZN12_GLOBAL__N_115FieldMemcpyizer10emitMemcpyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_115FieldMemcpyizer10emitMemcpyEv")
  //</editor-fold>
  public void emitMemcpy() {
    // Give the subclass a chance to bail out if it feels the memcpy isn't
    // worth it (e.g. Hasn't aggregated enough data).
    if (!(FirstField != null)) {
      return;
    }
    
    long/*uint64_t*/ FirstByteOffset;
    if (FirstField.isBitField()) {
      final /*const*/ CGRecordLayout /*&*/ RL = CGF.getTypes().getCGRecordLayout(FirstField.getParent());
      final /*const*/ CGBitFieldInfo /*&*/ BFInfo = RL.getBitFieldInfo(FirstField);
      // FirstFieldOffset is not appropriate for bitfields,
      // we need to use the storage offset instead.
      FirstByteOffset = CGF.getContext().toBits(new CharUnits(BFInfo.StorageOffset));
    } else {
      FirstByteOffset = FirstFieldOffset;
    }
    
    CharUnits MemcpySize = getMemcpySize(FirstByteOffset);
    QualType RecordTy = CGF.getContext().getTypeDeclType(ClassDecl);
    Address ThisPtr = CGF.LoadCXXThisAddress();
    LValue DestLV = CGF.MakeAddrLValue(new Address(ThisPtr), new QualType(RecordTy));
    LValue Dest = CGF.EmitLValueForFieldInitialization(new LValue(DestLV), FirstField);
    Value /*P*/ SrcPtr = CGF.Builder.CreateLoad(CGF.GetAddrOfLocalVar(SrcRec));
    LValue SrcLV = CGF.MakeNaturalAlignAddrLValue(SrcPtr, new QualType(RecordTy));
    LValue Src = CGF.EmitLValueForFieldInitialization(new LValue(SrcLV), FirstField);
    
    emitMemcpyIR(Dest.isBitField() ? Dest.getBitFieldAddress() : Dest.getAddress(), 
        Src.isBitField() ? Src.getBitFieldAddress() : Src.getAddress(), 
        new CharUnits(MemcpySize));
    reset();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldMemcpyizer::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1066,
   FQN="(anonymous namespace)::FieldMemcpyizer::reset", NM="_ZN12_GLOBAL__N_115FieldMemcpyizer5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_115FieldMemcpyizer5resetEv")
  //</editor-fold>
  public void reset() {
    FirstField = null;
  }

/*protected:*/
  protected final CodeGenFunction /*&*/ CGF;
  protected /*const*/ CXXRecordDecl /*P*/ ClassDecl;
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldMemcpyizer::emitMemcpyIR">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1075,
   FQN="(anonymous namespace)::FieldMemcpyizer::emitMemcpyIR", NM="_ZN12_GLOBAL__N_115FieldMemcpyizer12emitMemcpyIREN5clang7CodeGen7AddressES3_NS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_115FieldMemcpyizer12emitMemcpyIREN5clang7CodeGen7AddressES3_NS1_9CharUnitsE")
  //</editor-fold>
  private void emitMemcpyIR(Address DestPtr, Address SrcPtr, CharUnits Size) {
    PointerType /*P*/ DPT = DestPtr.getType();
    Type /*P*/ DBP = Type.getInt8PtrTy(CGF.getLLVMContext(), DPT.getAddressSpace());
    DestPtr.$assignMove(CGF.Builder.CreateBitCast(new Address(DestPtr), DBP));
    
    PointerType /*P*/ SPT = SrcPtr.getType();
    Type /*P*/ SBP = Type.getInt8PtrTy(CGF.getLLVMContext(), SPT.getAddressSpace());
    SrcPtr.$assignMove(CGF.Builder.CreateBitCast(new Address(SrcPtr), SBP));
    
    CGF.Builder.CreateMemCpy(new Address(DestPtr), new Address(SrcPtr), Size.getQuantity());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldMemcpyizer::addInitialField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1089,
   FQN="(anonymous namespace)::FieldMemcpyizer::addInitialField", NM="_ZN12_GLOBAL__N_115FieldMemcpyizer15addInitialFieldEPN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_115FieldMemcpyizer15addInitialFieldEPN5clang9FieldDeclE")
  //</editor-fold>
  private void addInitialField(FieldDecl /*P*/ F) {
    FirstField = F;
    LastField = F;
    FirstFieldOffset = RecLayout.getFieldOffset(F.getFieldIndex());
    LastFieldOffset = FirstFieldOffset;
    LastAddedFieldIndex = F.getFieldIndex();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldMemcpyizer::addNextField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1097,
   FQN="(anonymous namespace)::FieldMemcpyizer::addNextField", NM="_ZN12_GLOBAL__N_115FieldMemcpyizer12addNextFieldEPN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_115FieldMemcpyizer12addNextFieldEPN5clang9FieldDeclE")
  //</editor-fold>
  private void addNextField(FieldDecl /*P*/ F) {
    // For the most part, the following invariant will hold:
    //   F->getFieldIndex() == LastAddedFieldIndex + 1
    // The one exception is that Sema won't add a copy-initializer for an
    // unnamed bitfield, which will show up here as a gap in the sequence.
    assert ($greatereq_uint(F.getFieldIndex(), LastAddedFieldIndex + 1)) : "Cannot aggregate fields out of order.";
    LastAddedFieldIndex = F.getFieldIndex();
    
    // The 'first' and 'last' fields are chosen by offset, rather than field
    // index. This allows the code to support bitfields, as well as regular
    // fields.
    long/*uint64_t*/ FOffset = RecLayout.getFieldOffset(F.getFieldIndex());
    if ($less_ulong(FOffset, FirstFieldOffset)) {
      FirstField = F;
      FirstFieldOffset = FOffset;
    } else if ($greater_ulong(FOffset, LastFieldOffset)) {
      LastField = F;
      LastFieldOffset = FOffset;
    }
  }

  
  private /*const*/ VarDecl /*P*/ SrcRec;
  private final /*const*/ ASTRecordLayout /*&*/ RecLayout;
  private FieldDecl /*P*/ FirstField;
  private FieldDecl /*P*/ LastField;
  private long/*uint64_t*/ FirstFieldOffset;
  private long/*uint64_t*/ LastFieldOffset;
  private /*uint*/int LastAddedFieldIndex;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public void $destroy() { }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "CGF=" + CGF // NOI18N
              + ", ClassDecl=" + "[CXXRecordDecl]" // NOI18N
              + ", SrcRec=" + "[VarDecl]" // NOI18N
              + ", RecLayout=" + RecLayout // NOI18N
              + ", FirstField=" + "[FieldDecl]" // NOI18N
              + ", LastField=" + "[FieldDecl]" // NOI18N
              + ", FirstFieldOffset=" + FirstFieldOffset // NOI18N
              + ", LastFieldOffset=" + LastFieldOffset // NOI18N
              + ", LastAddedFieldIndex=" + LastAddedFieldIndex; // NOI18N
  }
}

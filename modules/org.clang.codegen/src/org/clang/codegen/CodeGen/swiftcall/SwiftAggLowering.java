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

package org.clang.codegen.CodeGen.swiftcall;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.java.ClangCodeGenFunctionPointers.*;
import static org.clang.ast.CharUnitsGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.codegen.CodeGen.swiftcall.SwiftcallGlobals.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.codegen.impl.SwiftCallingConvStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/SwiftCallingConv.h", line = 43,
 FQN="clang::CodeGen::swiftcall::SwiftAggLowering", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLoweringE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLoweringE")
//</editor-fold>
public class SwiftAggLowering implements Destructors.ClassWithDestructor {
  private final CodeGenModule /*&*/ CGM;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::StorageEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/SwiftCallingConv.h", line = 46,
   FQN="clang::CodeGen::swiftcall::SwiftAggLowering::StorageEntry", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12StorageEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12StorageEntryE")
  //</editor-fold>
  private static class/*struct*/ StorageEntry {
    public CharUnits Begin;
    public CharUnits End;
    public org.llvm.ir.Type /*P*/ Type;
    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::StorageEntry::getWidth">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/SwiftCallingConv.h", line = 51,
     FQN="clang::CodeGen::swiftcall::SwiftAggLowering::StorageEntry::getWidth", NM="_ZNK5clang7CodeGen9swiftcall16SwiftAggLowering12StorageEntry8getWidthEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZNK5clang7CodeGen9swiftcall16SwiftAggLowering12StorageEntry8getWidthEv")
    //</editor-fold>
    public CharUnits getWidth() /*const*/ {
      return End.$sub(Begin);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::StorageEntry::StorageEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/SwiftCallingConv.h", line = 46,
     FQN="clang::CodeGen::swiftcall::SwiftAggLowering::StorageEntry::StorageEntry", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12StorageEntryC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12StorageEntryC1Ev")
    //</editor-fold>
    public /*inline*/ StorageEntry() {
      // : Begin(), End() 
      //START JInit
      this.Begin = new CharUnits();
      this.End = new CharUnits();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::StorageEntry::StorageEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/SwiftCallingConv.h", line = 46,
     FQN="clang::CodeGen::swiftcall::SwiftAggLowering::StorageEntry::StorageEntry", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12StorageEntryC1ERKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12StorageEntryC1ERKS3_")
    //</editor-fold>
    public /*inline*/ StorageEntry(final /*const*/ StorageEntry /*&*/ $Prm0) {
      // : Begin(.Begin), End(.End), Type(.Type) 
      //START JInit
      this.Begin = new CharUnits($Prm0.Begin);
      this.End = new CharUnits($Prm0.End);
      this.Type = $Prm0.Type;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::StorageEntry::StorageEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/SwiftCallingConv.h", line = 46,
     FQN="clang::CodeGen::swiftcall::SwiftAggLowering::StorageEntry::StorageEntry", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12StorageEntryC1EOS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12StorageEntryC1EOS3_")
    //</editor-fold>
    public /*inline*/ StorageEntry(JD$Move _dparam, final StorageEntry /*&&*/$Prm0) {
      // : Begin(static_cast<StorageEntry &&>().Begin), End(static_cast<StorageEntry &&>().End), Type(static_cast<StorageEntry &&>().Type) 
      //START JInit
      this.Begin = new CharUnits(JD$Move.INSTANCE, $Prm0.Begin);
      this.End = new CharUnits(JD$Move.INSTANCE, $Prm0.End);
      this.Type = $Prm0.Type;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::StorageEntry::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/SwiftCallingConv.h", line = 46,
     FQN="clang::CodeGen::swiftcall::SwiftAggLowering::StorageEntry::operator=", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12StorageEntryaSERKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12StorageEntryaSERKS3_")
    //</editor-fold>
    public /*inline*/ StorageEntry /*&*/ $assign(final /*const*/ StorageEntry /*&*/ $Prm0) {
      this.Begin.$assign($Prm0.Begin);
      this.End.$assign($Prm0.End);
      this.Type = $Prm0.Type;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::StorageEntry::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/SwiftCallingConv.h", line = 46,
     FQN="clang::CodeGen::swiftcall::SwiftAggLowering::StorageEntry::operator=", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12StorageEntryaSEOS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12StorageEntryaSEOS3_")
    //</editor-fold>
    public /*inline*/ StorageEntry /*&*/ $assignMove(final StorageEntry /*&&*/$Prm0) {
      this.Begin.$assignMove($Prm0.Begin);
      this.End.$assignMove($Prm0.End);
      this.Type = $Prm0.Type;
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public StorageEntry(CharUnits Begin, CharUnits End, org.llvm.ir.Type /*P*/ Type) {
      this.Begin = Begin;
      this.End = End;
      this.Type = Type;
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Begin=" + Begin // NOI18N
                + ", End=" + End // NOI18N
                + ", Type=" + Type; // NOI18N
    }
  };
  private SmallVector<StorageEntry> Entries;
  private boolean Finished/* = false*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::SwiftAggLowering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/SwiftCallingConv.h", line = 59,
   FQN="clang::CodeGen::swiftcall::SwiftAggLowering::SwiftAggLowering", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLoweringC1ERNS0_13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLoweringC1ERNS0_13CodeGenModuleE")
  //</editor-fold>
  public SwiftAggLowering(final CodeGenModule /*&*/ CGM) {
    // : CGM(CGM), Entries(), Finished(false) 
    //START JInit
    this./*&*/CGM=/*&*/CGM;
    this.Entries = new SmallVector<StorageEntry>(4, new StorageEntry());
    /*InClass*/this.Finished = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::addOpaqueData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/SwiftCallingConv.h", line = 61,
   FQN="clang::CodeGen::swiftcall::SwiftAggLowering::addOpaqueData", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLowering13addOpaqueDataENS_9CharUnitsES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLowering13addOpaqueDataENS_9CharUnitsES3_")
  //</editor-fold>
  public void addOpaqueData(CharUnits begin, CharUnits end) {
    addEntry((org.llvm.ir.Type /*P*/ )null, new CharUnits(begin), new CharUnits(end));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::addTypedData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 60,
   FQN="clang::CodeGen::swiftcall::SwiftAggLowering::addTypedData", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12addTypedDataENS_8QualTypeENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12addTypedDataENS_8QualTypeENS_9CharUnitsE")
  //</editor-fold>
  public void addTypedData(QualType type, CharUnits begin) {
    {
      // Deal with various aggregate types as special cases:
      
      // Record types.
      /*const*/ RecordType /*P*/ recType = type.$arrow().getAs$RecordType();
      if ((recType != null)) {
        addTypedData(recType.getDecl(), new CharUnits(begin));
        // Array types.
      } else if (type.$arrow().isArrayType()) {
        // Incomplete array types (flexible array members?) don't provide
        // data to lay out, and the other cases shouldn't be possible.
        /*const*/ ConstantArrayType /*P*/ arrayType = CGM.getContext().getAsConstantArrayType(new QualType(type));
        if (!(arrayType != null)) {
          return;
        }
        
        QualType eltType = arrayType.getElementType();
        CharUnits eltSize = CGM.getContext().getTypeSizeInChars(/*NO_COPY*/eltType);
        for (long/*uint64_t*/ i = $int2ulong(0), e = arrayType.getSize().getZExtValue(); i != e; ++i) {
          addTypedData(new QualType(eltType), begin.$add($star_long_CharUnits$C(i, eltSize)));
        }
        // Complex types.
      } else {
        /*const*/ ComplexType /*P*/ complexType = type.$arrow().getAs(ComplexType.class);
        if ((complexType != null)) {
          QualType eltType = complexType.getElementType();
          CharUnits eltSize = CGM.getContext().getTypeSizeInChars(/*NO_COPY*/eltType);
          org.llvm.ir.Type /*P*/ eltLLVMType = CGM.getTypes().ConvertType(new QualType(eltType));
          addTypedData(eltLLVMType, new CharUnits(begin), begin.$add(eltSize));
          addTypedData(eltLLVMType, begin.$add(eltSize), begin.$add($star_long_CharUnits$C(2, eltSize)));
          // Member pointer types.
        } else if ((type.$arrow().getAs(MemberPointerType.class) != null)) {
          // Just add it all as opaque.
          addOpaqueData(new CharUnits(begin), begin.$add(CGM.getContext().getTypeSizeInChars(/*NO_COPY*/type)));
          // Everything else is scalar and should not convert as an LLVM aggregate.
        } else {
          // We intentionally convert as !ForMem because we want to preserve
          // that a type was an i1.
          org.llvm.ir.Type /*P*/ llvmType = CGM.getTypes().ConvertType(new QualType(type));
          addTypedData(llvmType, new CharUnits(begin));
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::addTypedData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 102,
   FQN="clang::CodeGen::swiftcall::SwiftAggLowering::addTypedData", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12addTypedDataEPKNS_10RecordDeclENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12addTypedDataEPKNS_10RecordDeclENS_9CharUnitsE")
  //</editor-fold>
  public void addTypedData(/*const*/ RecordDecl /*P*/ record, CharUnits begin) {
    addTypedData(record, new CharUnits(begin), CGM.getContext().getASTRecordLayout(record));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::addTypedData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 106,
   FQN="clang::CodeGen::swiftcall::SwiftAggLowering::addTypedData", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12addTypedDataEPKNS_10RecordDeclENS_9CharUnitsERKNS_15ASTRecordLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12addTypedDataEPKNS_10RecordDeclENS_9CharUnitsERKNS_15ASTRecordLayoutE")
  //</editor-fold>
  public void addTypedData(/*const*/ RecordDecl /*P*/ record, CharUnits begin, 
              final /*const*/ ASTRecordLayout /*&*/ layout) {
    // Unions are a special case.
    if (record.isUnion()) {
      for (FieldDecl /*P*/ field : record.fields()) {
        if (field.isBitField()) {
          addBitFieldData(field, new CharUnits(begin), $int2ulong(0));
        } else {
          addTypedData(field.getType(), new CharUnits(begin));
        }
      }
      return;
    }
    
    // Note that correctness does not rely on us adding things in
    // their actual order of layout; it's just somewhat more efficient
    // for the builder.
    
    // With that in mind, add "early" C++ data.
    /*const*/ CXXRecordDecl /*P*/ cxxRecord = dyn_cast_CXXRecordDecl(record);
    if ((cxxRecord != null)) {
      //   - a v-table pointer, if the class adds its own
      if (layout.hasOwnVFPtr()) {
        addTypedData(CGM.Unnamed_field9.Int8PtrTy, new CharUnits(begin));
      }
      
      //   - non-virtual bases
      for (final /*const*/ CXXBaseSpecifier /*&*/ baseSpecifier : cxxRecord.bases$Const()) {
        if (baseSpecifier.isVirtual()) {
          continue;
        }
        
        CXXRecordDecl /*P*/ baseRecord = baseSpecifier.getType().$arrow().getAsCXXRecordDecl();
        addTypedData(baseRecord, begin.$add(layout.getBaseClassOffset(baseRecord)));
      }
      
      //   - a vbptr if the class adds its own
      if (layout.hasOwnVBPtr()) {
        addTypedData(CGM.Unnamed_field9.Int8PtrTy, begin.$add(layout.getVBPtrOffset()));
      }
    }
    
    // Add fields.
    for (FieldDecl /*P*/ field : record.fields()) {
      long/*uint64_t*/ fieldOffsetInBits = layout.getFieldOffset(field.getFieldIndex());
      if (field.isBitField()) {
        addBitFieldData(field, new CharUnits(begin), fieldOffsetInBits);
      } else {
        addTypedData(field.getType(), 
            begin.$add(CGM.getContext().toCharUnitsFromBits(fieldOffsetInBits)));
      }
    }
    
    // Add "late" C++ data:
    if ((cxxRecord != null)) {
      //   - virtual bases
      for (final /*const*/ CXXBaseSpecifier /*&*/ vbaseSpecifier : cxxRecord.vbases$Const()) {
        CXXRecordDecl /*P*/ baseRecord = vbaseSpecifier.getType().$arrow().getAsCXXRecordDecl();
        addTypedData(baseRecord, begin.$add(layout.getVBaseClassOffset(baseRecord)));
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::addTypedData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 190,
   FQN="clang::CodeGen::swiftcall::SwiftAggLowering::addTypedData", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12addTypedDataEPN4llvm4TypeENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12addTypedDataEPN4llvm4TypeENS_9CharUnitsE")
  //</editor-fold>
  public void addTypedData(org.llvm.ir.Type /*P*/ type, CharUnits begin) {
    assert ((type != null)) : "didn't provide type for typed data";
    addTypedData(type, new CharUnits(begin), begin.$add(getTypeStoreSize(CGM, type)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::addTypedData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 195,
   FQN="clang::CodeGen::swiftcall::SwiftAggLowering::addTypedData", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12addTypedDataEPN4llvm4TypeENS_9CharUnitsES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLowering12addTypedDataEPN4llvm4TypeENS_9CharUnitsES6_")
  //</editor-fold>
  public void addTypedData(org.llvm.ir.Type /*P*/ type, 
              CharUnits begin, CharUnits end) {
    assert ((type != null)) : "didn't provide type for typed data";
    assert (getTypeStoreSize(CGM, type).$eq(end.$sub(begin)));
    {
      
      // Legalize vector types.
      org.llvm.ir.VectorType /*P*/ vecTy = dyn_cast_VectorType(type);
      if ((vecTy != null)) {
        SmallVector<org.llvm.ir.Type /*P*/ > componentTys/*J*/= new SmallVector<org.llvm.ir.Type /*P*/ >(4, (org.llvm.ir.Type /*P*/ )null);
        legalizeVectorType(CGM, end.$sub(begin), vecTy, componentTys);
        assert ($greatereq_uint(componentTys.size(), 1));
        
        // Walk the initial components.
        for (/*size_t*/int i = 0, e = componentTys.size(); i != e - 1; ++i) {
          org.llvm.ir.Type /*P*/ componentTy = componentTys.$at(i);
          CharUnits componentSize = getTypeStoreSize(CGM, componentTy);
          assert (componentSize.$less(end.$sub(begin)));
          addLegalTypedData(componentTy, new CharUnits(begin), begin.$add(componentSize));
          begin.$addassign(componentSize);
        }
        
        addLegalTypedData(componentTys.back(), new CharUnits(begin), new CharUnits(end));
        /*JAVA:return*/return;
      }
    }
    {
      
      // Legalize integer types.
      IntegerType /*P*/ intTy = dyn_cast_IntegerType(type);
      if ((intTy != null)) {
        if (!isLegalIntegerType(CGM, intTy)) {
          addOpaqueData(new CharUnits(begin), new CharUnits(end));
          /*JAVA:return*/return;
        }
      }
    }
    
    // All other types should be legal.
    addLegalTypedData(type, new CharUnits(begin), new CharUnits(end));
    /*JAVA:return*/return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::finish">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 414,
   FQN="clang::CodeGen::swiftcall::SwiftAggLowering::finish", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLowering6finishEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLowering6finishEv")
  //</editor-fold>
  public void finish() {
    if (Entries.empty()) {
      Finished = true;
      return;
    }
    
    // We logically split the layout down into a series of chunks of this size,
    // which is generally the size of a pointer.
    /*const*/ CharUnits chunkSize = getMaximumVoluntaryIntegerSize(CGM);
    
    // First pass: if two entries share a chunk, make them both opaque
    // and stretch one to meet the next.
    boolean hasOpaqueEntries = (Entries.$at(0).Type == null);
    for (/*size_t*/int i = 1, e = Entries.size(); i != e; ++i) {
      if (areBytesInSameUnit(Entries.$at(i - 1).End.$sub(CharUnits.One()), 
          new CharUnits(Entries.$at(i).Begin), new CharUnits(chunkSize))) {
        Entries.$at(i - 1).Type = null;
        Entries.$at(i).Type = null;
        Entries.$at(i - 1).End.$assign(Entries.$at(i).Begin);
        hasOpaqueEntries = true;
      } else if (Entries.$at(i).Type == null) {
        hasOpaqueEntries = true;
      }
    }
    
    // The rest of the algorithm leaves non-opaque entries alone, so if we
    // have no opaque entries, we're done.
    if (!hasOpaqueEntries) {
      Finished = true;
      return;
    }
    
    // Okay, move the entries to a temporary and rebuild Entries.
    SmallVector<StorageEntry> orig = new SmallVector<StorageEntry>(JD$Move.INSTANCE, std.move(Entries));
    assert (Entries.empty());
    
    for (/*size_t*/int i = 0, e = orig.size(); i != e; ++i) {
      // Just copy over non-opaque entries.
      if (orig.$at(i).Type != null) {
        Entries.push_back(orig.$at(i));
        continue;
      }
      
      // Scan forward to determine the full extent of the next opaque range.
      // We know from the first pass that only contiguous ranges will overlap
      // the same aligned chunk.
      CharUnits begin = new CharUnits(orig.$at(i).Begin);
      CharUnits end = new CharUnits(orig.$at(i).End);
      while (i + 1 != e
         && orig.$at(i + 1).Type == null
         && end.$eq(orig.$at(i + 1).Begin)) {
        end.$assign(orig.$at(i + 1).End);
        i++;
      }
      
      // Add an entry per intersected chunk.
      do {
        // Find the smallest aligned storage unit in the maximal aligned
        // storage unit containing 'begin' that contains all the bytes in
        // the intersection between the range and this chunk.
        CharUnits localBegin = new CharUnits(begin);
        CharUnits chunkBegin = getOffsetAtStartOfUnit(new CharUnits(localBegin), new CharUnits(chunkSize));
        CharUnits chunkEnd = chunkBegin.$add(chunkSize);
        CharUnits localEnd = new CharUnits(std.min(end, chunkEnd));
        
        // Just do a simple loop over ever-increasing unit sizes.
        CharUnits unitSize = CharUnits.One();
        CharUnits unitBegin/*J*/= new CharUnits();
        CharUnits unitEnd/*J*/= new CharUnits();
        for (;; unitSize.$starassign(2)) {
          assert (unitSize.$lesseq(chunkSize));
          unitBegin.$assignMove(getOffsetAtStartOfUnit(new CharUnits(localBegin), new CharUnits(unitSize)));
          unitEnd.$assignMove(unitBegin.$add(unitSize));
          if (unitEnd.$greatereq(localEnd)) {
            break;
          }
        }
        
        // Add an entry for this unit.
        IntegerType /*P*/ entryTy = IntegerType.get(CGM.getLLVMContext(), 
            $long2uint(CGM.getContext().toBits(new CharUnits(unitSize))));
        Entries.push_back(new StorageEntry(unitBegin, unitEnd, entryTy));
        
        // The next chunk starts where this chunk left off.
        begin.$assign(localEnd);
      } while (begin.$noteq(end));
    }
    
    // Okay, finally finished.
    Finished = true;
  }

  
  /// Does this lowering require passing any data?
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/SwiftCallingConv.h", line = 75,
   FQN="clang::CodeGen::swiftcall::SwiftAggLowering::empty", NM="_ZNK5clang7CodeGen9swiftcall16SwiftAggLowering5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZNK5clang7CodeGen9swiftcall16SwiftAggLowering5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    assert (Finished) : "didn't finish lowering before calling empty()";
    return Entries.empty();
  }

  
  /// According to the target Swift ABI, should a value with this lowering
  /// be passed indirectly?
  ///
  /// Note that this decision is based purely on the data layout of the
  /// value and does not consider whether the type is address-only,
  /// must be passed indirectly to match a function abstraction pattern, or
  /// anything else that is expected to be handled by high-level lowering.
  ///
  /// \param asReturnValue - if true, answer whether it should be passed
  ///   indirectly as a return value; if false, answer whether it should be
  ///   passed indirectly as an argument
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::shouldPassIndirectly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 570,
   FQN="clang::CodeGen::swiftcall::SwiftAggLowering::shouldPassIndirectly", NM="_ZNK5clang7CodeGen9swiftcall16SwiftAggLowering20shouldPassIndirectlyEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZNK5clang7CodeGen9swiftcall16SwiftAggLowering20shouldPassIndirectlyEb")
  //</editor-fold>
  public boolean shouldPassIndirectly(boolean asReturnValue) /*const*/ {
    assert (Finished) : "haven't yet finished lowering";
    
    // Empty types don't need to be passed indirectly.
    if (Entries.empty()) {
      return false;
    }
    
    CharUnits totalSize = new CharUnits(Entries.back$Const().End);
    
    // Avoid copying the array of types when there's just a single element.
    if (Entries.size() == 1) {
      return getSwiftABIInfo(CGM).shouldPassIndirectlyForSwift(new CharUnits(totalSize), 
          new ArrayRef<org.llvm.ir.Type /*P*/ >(Entries.back$Const().Type, true), 
          asReturnValue);
    }
    
    SmallVector<org.llvm.ir.Type /*P*/ > componentTys/*J*/= new SmallVector<org.llvm.ir.Type /*P*/ >(8, (org.llvm.ir.Type /*P*/ )null);
    componentTys.reserve(Entries.size());
    for (final /*const*/ StorageEntry /*&*/ entry : Entries) {
      componentTys.push_back(entry.Type);
    }
    return getSwiftABIInfo(CGM).shouldPassIndirectlyForSwift(new CharUnits(totalSize), 
        new ArrayRef<org.llvm.ir.Type /*P*/ >(componentTys, true), 
        asReturnValue);
  }

  
  /*using EnumerationCallback = llvm::function_ref<void (CharUnits, llvm::Type *)>*/;
  
  /// Enumerate the expanded components of this type.
  ///
  /// The component types will always be legal vector, floating-point,
  /// integer, or pointer types.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::enumerateComponents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 505,
   FQN="clang::CodeGen::swiftcall::SwiftAggLowering::enumerateComponents", NM="_ZNK5clang7CodeGen9swiftcall16SwiftAggLowering19enumerateComponentsEN4llvm12function_refIFvNS_9CharUnitsEPNS3_4TypeEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZNK5clang7CodeGen9swiftcall16SwiftAggLowering19enumerateComponentsEN4llvm12function_refIFvNS_9CharUnitsEPNS3_4TypeEEEE")
  //</editor-fold>
  public void enumerateComponents(EnumerationCallback callback) /*const*/ {
    assert (Finished) : "haven't yet finished lowering";
    
    for (final /*const*/ StorageEntry /*&*/ entry : Entries) {
      callback.$call(new CharUnits(entry.Begin), entry.Type);
    }
  }

  
  /// Return the types for a coerce-and-expand operation.
  ///
  /// The first type matches the memory layout of the data that's been
  /// added to this structure, including explicit [N x i8] arrays for any
  /// internal padding.
  ///
  /// The second type removes any internal padding members and, if only
  /// one element remains, is simply that element type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::getCoerceAndExpandTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 513,
   FQN="clang::CodeGen::swiftcall::SwiftAggLowering::getCoerceAndExpandTypes", NM="_ZNK5clang7CodeGen9swiftcall16SwiftAggLowering23getCoerceAndExpandTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZNK5clang7CodeGen9swiftcall16SwiftAggLowering23getCoerceAndExpandTypesEv")
  //</editor-fold>
  public std.pair<StructType /*P*/ , org.llvm.ir.Type /*P*/ > getCoerceAndExpandTypes() /*const*/ {
    assert (Finished) : "haven't yet finished lowering";
    
    final LLVMContext /*&*/ ctx = CGM.getLLVMContext();
    if (Entries.empty()) {
      StructType /*P*/ type = StructType.get(ctx);
      return /*{ */new std.pairPtrPtr<StructType /*P*/ , org.llvm.ir.Type /*P*/ >(JD$T$RR_T1$RR.INSTANCE, type, type)/* }*/;
    }
    
    SmallVector<org.llvm.ir.Type /*P*/ > elts/*J*/= new SmallVector<org.llvm.ir.Type /*P*/ >(8, (org.llvm.ir.Type /*P*/ )null);
    CharUnits lastEnd = CharUnits.Zero();
    boolean hasPadding = false;
    boolean packed = false;
    for (final /*const*/ StorageEntry /*&*/ entry : Entries) {
      if (entry.Begin.$noteq(lastEnd)) {
        CharUnits paddingSize = entry.Begin.$sub(lastEnd);
        assert (!paddingSize.isNegative());
        
        org.llvm.ir.ArrayType /*P*/ padding = org.llvm.ir.ArrayType.get(org.llvm.ir.Type.getInt8Ty(ctx), 
            paddingSize.getQuantity());
        elts.push_back(padding);
        hasPadding = true;
      }
      if (!packed && !entry.Begin.isMultipleOf(CharUnits.fromQuantity($uint2long(CGM.getDataLayout().getABITypeAlignment(entry.Type))))) {
        packed = true;
      }
      
      elts.push_back(entry.Type);
      lastEnd.$assign(entry.End);
    }
    
    // We don't need to adjust 'packed' to deal with possible tail padding
    // because we never do that kind of access through the coercion type.
    StructType /*P*/ coercionType = StructType.get(ctx, new ArrayRef<org.llvm.ir.Type /*P*/ >(elts, true), packed);
    
    org.llvm.ir.Type /*P*/ unpaddedType = coercionType;
    if (hasPadding) {
      elts.clear();
      for (final /*const*/ StorageEntry /*&*/ entry : Entries) {
        elts.push_back(entry.Type);
      }
      if (elts.size() == 1) {
        unpaddedType = elts.$at(0);
      } else {
        unpaddedType = StructType.get(ctx, new ArrayRef<org.llvm.ir.Type /*P*/ >(elts, true), /*packed*/ false);
      }
    } else if (Entries.size() == 1) {
      unpaddedType = Entries.$at$Const(0).Type;
    }
    
    return /*{ */new std.pairPtrPtr<StructType /*P*/ , org.llvm.ir.Type /*P*/ >(JD$T$RR_T1$RR.INSTANCE, coercionType, unpaddedType)/* }*/;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::addBitFieldData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 167,
   FQN="clang::CodeGen::swiftcall::SwiftAggLowering::addBitFieldData", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLowering15addBitFieldDataEPKNS_9FieldDeclENS_9CharUnitsEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLowering15addBitFieldDataEPKNS_9FieldDeclENS_9CharUnitsEy")
  //</editor-fold>
  private void addBitFieldData(/*const*/ FieldDecl /*P*/ bitfield, 
                 CharUnits recordBegin, 
                 long/*uint64_t*/ bitfieldBitBegin) {
    assert (bitfield.isBitField());
    final ASTContext /*&*/ ctx = CGM.getContext();
    /*uint*/int width = bitfield.getBitWidthValue(ctx);
    
    // We can ignore zero-width bit-fields.
    if (width == 0) {
      return;
    }
    
    // toCharUnitsFromBits rounds down.
    CharUnits bitfieldByteBegin = ctx.toCharUnitsFromBits(bitfieldBitBegin);
    
    // Find the offset of the last byte that is partially occupied by the
    // bit-field; since we otherwise expect exclusive ends, the end is the
    // next byte.
    long/*uint64_t*/ bitfieldBitLast = bitfieldBitBegin + $uint2ullong(width) - $int2ullong(1);
    CharUnits bitfieldByteEnd = ctx.toCharUnitsFromBits(bitfieldBitLast).$add(CharUnits.One());
    addOpaqueData(recordBegin.$add(bitfieldByteBegin), 
        recordBegin.$add(bitfieldByteEnd));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::addLegalTypedData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 228,
   FQN="clang::CodeGen::swiftcall::SwiftAggLowering::addLegalTypedData", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLowering17addLegalTypedDataEPN4llvm4TypeENS_9CharUnitsES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLowering17addLegalTypedDataEPN4llvm4TypeENS_9CharUnitsES6_")
  //</editor-fold>
  private void addLegalTypedData(org.llvm.ir.Type /*P*/ type, 
                   CharUnits begin, CharUnits end) {
    // Require the type to be naturally aligned.
    if (!begin.isZero() && !begin.isMultipleOf(getNaturalAlignment(CGM, type))) {
      {
        
        // Try splitting vector types.
        org.llvm.ir.VectorType /*P*/ vecTy = dyn_cast_VectorType(type);
        if ((vecTy != null)) {
          std.pairTypeUInt<org.llvm.ir.Type /*P*/ > split = splitLegalVectorType(CGM, end.$sub(begin), vecTy);
          org.llvm.ir.Type /*P*/ eltTy = split.first;
          /*uint*/int numElts = split.second;
          
          CharUnits eltSize = (end.$sub(begin)).$slash($uint2long(numElts));
          assert (eltSize.$eq(getTypeStoreSize(CGM, eltTy)));
          for (/*size_t*/int i = 0, e = numElts; i != e; ++i) {
            addLegalTypedData(eltTy, new CharUnits(begin), begin.$add(eltSize));
            begin.$addassign(eltSize);
          }
          assert (begin.$eq(end));
          return;
        }
      }
      
      addOpaqueData(new CharUnits(begin), new CharUnits(end));
      /*JAVA:return*/return;
    }
    
    addEntry(type, new CharUnits(begin), new CharUnits(end));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::addEntry">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 255,
   FQN="clang::CodeGen::swiftcall::SwiftAggLowering::addEntry", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLowering8addEntryEPN4llvm4TypeENS_9CharUnitsES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLowering8addEntryEPN4llvm4TypeENS_9CharUnitsES6_")
  //</editor-fold>
  private void addEntry(org.llvm.ir.Type /*P*/ type, 
          CharUnits begin, CharUnits end) {
    assert ((!(type != null) || (!isa_StructType(type) && !isa_ArrayType(type)))) : "cannot add aggregate-typed data";
    assert (!(type != null) || begin.isMultipleOf(getNaturalAlignment(CGM, type)));
    
    // Fast path: we can just add entries to the end.
    if (Entries.empty() || Entries.back().End.$lesseq(begin)) {
      Entries.push_back(new StorageEntry(begin, end, type));
      return;
    }
    
    // Find the first existing entry that ends after the start of the new data.
    // TODO: do a binary search if Entries is big enough for it to matter.
    /*size_t*/int index = Entries.size() - 1;
    while (index != 0) {
      if (Entries.$at(index - 1).End.$lesseq(begin)) {
        break;
      }
      --index;
    }
    
    // The entry ends after the start of the new data.
    // If the entry starts after the end of the new data, there's no conflict.
    if (Entries.$at(index).Begin.$greatereq(end)) {
      // This insertion is potentially O(n), but the way we generally build
      // these layouts makes that unlikely to matter: we'd need a union of
      // several very large types.
      Entries.insert(Entries.begin().$add(index), new StorageEntry(begin, end, type));
      return;
    }
   restartAfterSplit:
    while(true){
    // Simplest case: an exact overlap.
    if (Entries.$at(index).Begin.$eq(begin) && Entries.$at(index).End.$eq(end)) {
      // If the types match exactly, great.
      if (Entries.$at(index).Type == type) {
        return;
      }
      
      // If either type is opaque, make the entry opaque and return.
      if (Entries.$at(index).Type == null) {
        return;
      } else if (type == null) {
        Entries.$at(index).Type = null;
        return;
      }
      {
        
        // If they disagree in an ABI-agnostic way, just resolve the conflict
        // arbitrarily.
        org.llvm.ir.Type /*P*/ entryType = getCommonType(Entries.$at(index).Type, type);
        if ((entryType != null)) {
          Entries.$at(index).Type = entryType;
          return;
        }
      }
      
      // Otherwise, make the entry opaque.
      Entries.$at(index).Type = null;
      return;
    }
    {
      
      // Okay, we have an overlapping conflict of some sort.
      
      // If we have a vector type, split it.
      org.llvm.ir.VectorType /*P*/ vecTy = dyn_cast_or_null_VectorType(type);
      if ((vecTy != null)) {
        org.llvm.ir.Type /*P*/ eltTy = vecTy.getElementType();
        CharUnits eltSize = (end.$sub(begin)).$slash($uint2long(vecTy.getNumElements()));
        assert (eltSize.$eq(getTypeStoreSize(CGM, eltTy)));
        for (/*uint*/int i = 0, e = vecTy.getNumElements(); i != e; ++i) {
          addEntry(eltTy, new CharUnits(begin), begin.$add(eltSize));
          begin.$addassign(eltSize);
        }
        assert (begin.$eq(end));
        return;
      }
    }
    
    // If the entry is a vector type, split it and try again.
    if ((Entries.$at(index).Type != null) && Entries.$at(index).Type.isVectorTy()) {
      splitVectorEntry(index);
      continue restartAfterSplit;
    }
    break;
    }
    // Okay, we have no choice but to make the existing entry opaque.
    Entries.$at(index).Type = null;
    
    // Stretch the start of the entry to the beginning of the range.
    if (begin.$less(Entries.$at(index).Begin)) {
      Entries.$at(index).Begin.$assign(begin);
      assert (index == 0 || begin.$greatereq(Entries.$at(index - 1).End));
    }
    
    // Stretch the end of the entry to the end of the range; but if we run
    // into the start of the next entry, just leave the range there and repeat.
    while (end.$greater(Entries.$at(index).End)) {
      assert (Entries.$at(index).Type == null);
      
      // If the range doesn't overlap the next entry, we're done.
      if (index == Entries.size() - 1 || end.$lesseq(Entries.$at(index + 1).Begin)) {
        Entries.$at(index).End.$assign(end);
        break;
      }
      
      // Otherwise, stretch to the start of the next entry.
      Entries.$at(index).End.$assign(Entries.$at(index + 1).Begin);
      
      // Continue with the next entry.
      index++;
      
      // This entry needs to be made opaque if it is not already.
      if (Entries.$at(index).Type == null) {
        continue;
      }
      
      // Split vector entries unless we completely subsume them.
      if (Entries.$at(index).Type.isVectorTy()
         && end.$less(Entries.$at(index).End)) {
        splitVectorEntry(index);
      }
      
      // Make the entry opaque.
      Entries.$at(index).Type = null;
    }
  }

  
  /// Replace the entry of vector type at offset 'index' with a sequence
  /// of its component vectors.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::splitVectorEntry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 380,
   FQN="clang::CodeGen::swiftcall::SwiftAggLowering::splitVectorEntry", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLowering16splitVectorEntryEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLowering16splitVectorEntryEj")
  //</editor-fold>
  private void splitVectorEntry(/*uint*/int index) {
    org.llvm.ir.VectorType /*P*/ vecTy = cast_VectorType(Entries.$at(index).Type);
    std.pairTypeUInt<org.llvm.ir.Type /*P*/ > split = splitLegalVectorType(CGM, Entries.$at(index).getWidth(), vecTy);
    
    org.llvm.ir.Type /*P*/ eltTy = split.first;
    CharUnits eltSize = getTypeStoreSize(CGM, eltTy);
    /*uint*/int numElts = split.second;
    Entries.insert(/*AddrOf*/Entries.begin().$add(index + 1), numElts - 1, new StorageEntry());
    
    CharUnits begin = new CharUnits(Entries.$at(index).Begin);
    for (/*uint*/int i = 0; i != numElts; ++i) {
      Entries.$at(index).Type = eltTy;
      Entries.$at(index).Begin.$assign(begin);
      Entries.$at(index).End.$assignMove(begin.$add(eltSize));
      begin.$addassign(eltSize);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::SwiftAggLowering::~SwiftAggLowering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/SwiftCallingConv.h", line = 43,
   FQN="clang::CodeGen::swiftcall::SwiftAggLowering::~SwiftAggLowering", NM="_ZN5clang7CodeGen9swiftcall16SwiftAggLoweringD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall16SwiftAggLoweringD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Entries.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "CGM=" + CGM // NOI18N
              + ", Entries=" + Entries // NOI18N
              + ", Finished=" + Finished; // NOI18N
  }
}

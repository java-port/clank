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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.support.dwarf.Tag;


/// \brief Compile unit.
//<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 981,
 FQN="llvm::DICompileUnit", NM="_ZN4llvm13DICompileUnitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnitE")
//</editor-fold>
public class DICompileUnit extends /*public*/ DIScope implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::DebugEmissionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 985,
   FQN="llvm::DICompileUnit::DebugEmissionKind", NM="_ZN4llvm13DICompileUnit17DebugEmissionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnit17DebugEmissionKindE")
  //</editor-fold>
  public enum DebugEmissionKind/* : unsigned int*/ implements Native.NativeUIntEnum {
    NoDebug(0),
    FullDebug(NoDebug.getValue() + 1),
    LineTablesOnly(FullDebug.getValue() + 1),
    LastEmissionKind(DebugEmissionKind.LineTablesOnly.value);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DebugEmissionKind valueOf(int val) {
      DebugEmissionKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DebugEmissionKind[] VALUES;
      private static final DebugEmissionKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DebugEmissionKind kind : DebugEmissionKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DebugEmissionKind[min < 0 ? (1-min) : 0];
        VALUES = new DebugEmissionKind[max >= 0 ? (1+max) : 0];
        for (DebugEmissionKind kind : DebugEmissionKind.values()) {
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
    private DebugEmissionKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getEmissionKind">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 380,
   FQN="llvm::DICompileUnit::getEmissionKind", NM="_ZN4llvm13DICompileUnit15getEmissionKindENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnit15getEmissionKindENS_9StringRefE")
  //</editor-fold>
  public static Optional<DICompileUnit.DebugEmissionKind> getEmissionKind(StringRef Str) {
    return new StringSwitch<Optional<DebugEmissionKind> >(/*NO_COPY*/Str).
        Case(8, "NoDebug", new Optional<DebugEmissionKind>(JD$T$RR.INSTANCE, DebugEmissionKind.NoDebug)).
        Case(10, "FullDebug", new Optional<DebugEmissionKind>(JD$T$RR.INSTANCE, DebugEmissionKind.FullDebug)).
        Case(15, "LineTablesOnly", new Optional<DebugEmissionKind>(JD$T$RR.INSTANCE, DebugEmissionKind.LineTablesOnly)).
        Default(new Optional<DebugEmissionKind>(None));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::EmissionKindString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 389,
   FQN="llvm::DICompileUnit::EmissionKindString", NM="_ZN4llvm13DICompileUnit18EmissionKindStringENS0_17DebugEmissionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnit18EmissionKindStringENS0_17DebugEmissionKindE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ EmissionKindString(DebugEmissionKind EK) {
    switch (EK) {
     case NoDebug:
      return $("NoDebug");
     case FullDebug:
      return $("FullDebug");
     case LineTablesOnly:
      return $("LineTablesOnly");
    }
    return null;
  }

/*private:*/
  private /*uint*/int SourceLanguage;
  private boolean IsOptimized;
  private /*uint*/int RuntimeVersion;
  private /*uint*/int EmissionKind;
  private long/*uint64_t*/ DWOId;

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::DICompileUnit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1001,
   FQN="llvm::DICompileUnit::DICompileUnit", NM="_ZN4llvm13DICompileUnitC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjbjjyNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnitC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjbjjyNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DICompileUnit(final LLVMContext /*&*/ C, Metadata.StorageType Storage, /*uint*/int SourceLanguage,
      boolean IsOptimized, /*uint*/int RuntimeVersion,
      /*uint*/int EmissionKind, long/*uint64_t*/ DWOId, ArrayRef<Metadata /*P*/ > Ops) {
    // : DIScope(C, DICompileUnitKind, Storage, dwarf::DW_TAG_compile_unit, Ops), SourceLanguage(SourceLanguage), IsOptimized(IsOptimized), RuntimeVersion(RuntimeVersion), EmissionKind(EmissionKind), DWOId(DWOId)
    //START JInit
    super(C, MetadataKind.DICompileUnitKind.getValue(), Storage, $ushort2uint(Tag.DW_TAG_compile_unit), new ArrayRef<Metadata /*P*/ >(Ops));
    this.SourceLanguage = SourceLanguage;
    this.IsOptimized = IsOptimized;
    this.RuntimeVersion = RuntimeVersion;
    this.EmissionKind = EmissionKind;
    this.DWOId = DWOId;
    //END JInit
    assert (Storage != StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::~DICompileUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1010,
   FQN="llvm::DICompileUnit::~DICompileUnit", NM="_ZN4llvm13DICompileUnitD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm13DICompileUnitD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1012,
   FQN="llvm::DICompileUnit::getImpl", NM="_ZN4llvm13DICompileUnit7getImplERNS_11LLVMContextEjPNS_6DIFileENS_9StringRefEbS5_jS5_jNS_24MDTupleTypedArrayWrapperINS_15DICompositeTypeEEENS6_INS_7DIScopeEEENS6_INS_16DIGlobalVariableEEENS6_INS_16DIImportedEntityEEENS6_INS_11DIMacroNodeEEEyNS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnit7getImplERNS_11LLVMContextEjPNS_6DIFileENS_9StringRefEbS5_jS5_jNS_24MDTupleTypedArrayWrapperINS_15DICompositeTypeEEENS6_INS_7DIScopeEEENS6_INS_16DIGlobalVariableEEENS6_INS_16DIImportedEntityEEENS6_INS_11DIMacroNodeEEEyNS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DICompileUnit /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int SourceLanguage, DIFile /*P*/ File,
         StringRef Producer, boolean IsOptimized, StringRef Flags,
         /*uint*/int RuntimeVersion, StringRef SplitDebugFilename,
         /*uint*/int EmissionKind, MDTupleTypedArrayWrapper<DICompositeType> EnumTypes,
         MDTupleTypedArrayWrapper<DIScope> RetainedTypes, MDTupleTypedArrayWrapper<DIGlobalVariable> GlobalVariables,
         MDTupleTypedArrayWrapper<DIImportedEntity> ImportedEntities, MDTupleTypedArrayWrapper<DIMacroNode> Macros,
         long/*uint64_t*/ DWOId, Metadata.StorageType Storage) {
    return getImpl(Context, SourceLanguage, File,
         Producer, IsOptimized, Flags,
         RuntimeVersion, SplitDebugFilename,
         EmissionKind, EnumTypes,
         RetainedTypes, GlobalVariables,
         ImportedEntities, Macros,
         DWOId, Storage, true);
  }
  private static DICompileUnit /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int SourceLanguage, DIFile /*P*/ File,
         StringRef Producer, boolean IsOptimized, StringRef Flags,
         /*uint*/int RuntimeVersion, StringRef SplitDebugFilename,
         /*uint*/int EmissionKind, MDTupleTypedArrayWrapper<DICompositeType> EnumTypes,
         MDTupleTypedArrayWrapper<DIScope> RetainedTypes, MDTupleTypedArrayWrapper<DIGlobalVariable> GlobalVariables,
         MDTupleTypedArrayWrapper<DIImportedEntity> ImportedEntities, MDTupleTypedArrayWrapper<DIMacroNode> Macros,
         long/*uint64_t*/ DWOId, Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    return getImpl(Context, SourceLanguage, File, DINode.getCanonicalMDString(Context, new StringRef(Producer)),
        IsOptimized, DINode.getCanonicalMDString(Context, new StringRef(Flags)), RuntimeVersion,
        DINode.getCanonicalMDString(Context, new StringRef(SplitDebugFilename)), EmissionKind,
        EnumTypes.get(), RetainedTypes.get(), GlobalVariables.get(),
        ImportedEntities.get(), Macros.get(), DWOId, Storage, ShouldCreate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 358,
   FQN="llvm::DICompileUnit::getImpl", NM="_ZN4llvm13DICompileUnit7getImplERNS_11LLVMContextEjPNS_8MetadataEPNS_8MDStringEbS6_jS6_jS4_S4_S4_S4_S4_yNS3_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnit7getImplERNS_11LLVMContextEjPNS_8MetadataEPNS_8MDStringEbS6_jS6_jS4_S4_S4_S4_S4_yNS3_11StorageTypeEb")
  //</editor-fold>
  private static DICompileUnit /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int SourceLanguage, Metadata /*P*/ File,
         MDString /*P*/ Producer, boolean IsOptimized, MDString /*P*/ Flags,
         /*uint*/int RuntimeVersion, MDString /*P*/ SplitDebugFilename,
         /*uint*/int EmissionKind, Metadata /*P*/ EnumTypes, Metadata /*P*/ RetainedTypes,
         Metadata /*P*/ GlobalVariables, Metadata /*P*/ ImportedEntities, Metadata /*P*/ Macros,
         long/*uint64_t*/ DWOId, Metadata.StorageType Storage) {
    return getImpl(Context, SourceLanguage, File,
         Producer, IsOptimized, Flags,
         RuntimeVersion, SplitDebugFilename,
         EmissionKind, EnumTypes, RetainedTypes,
         GlobalVariables, ImportedEntities, Macros,
         DWOId, Storage, true);
  }
  private static DICompileUnit /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int SourceLanguage, Metadata /*P*/ File,
         MDString /*P*/ Producer, boolean IsOptimized, MDString /*P*/ Flags,
         /*uint*/int RuntimeVersion, MDString /*P*/ SplitDebugFilename,
         /*uint*/int EmissionKind, Metadata /*P*/ EnumTypes, Metadata /*P*/ RetainedTypes,
         Metadata /*P*/ GlobalVariables, Metadata /*P*/ ImportedEntities, Metadata /*P*/ Macros,
         long/*uint64_t*/ DWOId, Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    assert (Storage != StorageType.Uniqued) : "Cannot unique DICompileUnit";
    assert (DebugInfoMetadataStatics.isCanonical(Producer)) : "Expected canonical MDString";
    assert (DebugInfoMetadataStatics.isCanonical(Flags)) : "Expected canonical MDString";
    assert (DebugInfoMetadataStatics.isCanonical(SplitDebugFilename)) : "Expected canonical MDString";

    Metadata /*P*/ Ops[/*9*/] = new Metadata /*P*/  [/*9*/] {
      File, Producer, Flags, SplitDebugFilename,
      EnumTypes, RetainedTypes, GlobalVariables, ImportedEntities,
      Macros};
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DICompileUnit(Context, Storage, SourceLanguage, IsOptimized,
                    RuntimeVersion, EmissionKind, DWOId, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }),
        Storage);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1036,
   FQN="llvm::DICompileUnit::cloneImpl", NM="_ZNK4llvm13DICompileUnit9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DICompileUnit /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DICompileUnit.getTemporary(getContext(), getSourceLanguage(), getFile(), getProducer(),
        isOptimized(), getFlags(), getRuntimeVersion(), getSplitDebugFilename(),
        getEmissionKind(), getEnumTypes(), getRetainedTypes(),
        getGlobalVariables(), getImportedEntities(), getMacros(), DWOId);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1044,
   FQN="llvm::DICompileUnit::get", NM="_ZN4llvm13DICompileUnit3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnit3getEv")
  //</editor-fold>
  protected/*private*/ static void get() { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1045,
   FQN="llvm::DICompileUnit::getIfExists", NM="_ZN4llvm13DICompileUnit11getIfExistsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnit11getIfExistsEv")
  //</editor-fold>
  protected/*private*/ static void getIfExists() { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1048,
   FQN="llvm::DICompileUnit::getDistinct", NM="_ZN4llvm13DICompileUnit11getDistinctERNS_11LLVMContextEjPNS_6DIFileENS_9StringRefEbS5_jS5_NS0_17DebugEmissionKindENS_24MDTupleTypedArrayWrapperINS_15DICompositeTypeEEENS7_INS_7DIScopeEEENS7_INS_16DIGlobalVariableEEENS7_INS_16DIImportedEntityEEENS7_INS_11DIMacroNodeEEEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnit11getDistinctERNS_11LLVMContextEjPNS_6DIFileENS_9StringRefEbS5_jS5_NS0_17DebugEmissionKindENS_24MDTupleTypedArrayWrapperINS_15DICompositeTypeEEENS7_INS_7DIScopeEEENS7_INS_16DIGlobalVariableEEENS7_INS_16DIImportedEntityEEENS7_INS_11DIMacroNodeEEEy")
  //</editor-fold>
  public static DICompileUnit /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int SourceLanguage, DIFile /*P*/ File, StringRef Producer, boolean IsOptimized, StringRef Flags, /*uint*/int RuntimeVersion, StringRef SplitDebugFilename, DebugEmissionKind EmissionKind, MDTupleTypedArrayWrapper<DICompositeType> EnumTypes, MDTupleTypedArrayWrapper<DIScope> RetainedTypes, MDTupleTypedArrayWrapper<DIGlobalVariable> GlobalVariables, MDTupleTypedArrayWrapper<DIImportedEntity> ImportedEntities, MDTupleTypedArrayWrapper<DIMacroNode> Macros, long/*uint64_t*/ DWOId) {
    return DICompileUnit.getImpl(Context, SourceLanguage, File, new StringRef(Producer), IsOptimized, new StringRef(Flags), RuntimeVersion, new StringRef(SplitDebugFilename), EmissionKind.getValue(), new MDTupleTypedArrayWrapper<DICompositeType>(EnumTypes), new MDTupleTypedArrayWrapper<DIScope>(RetainedTypes), new MDTupleTypedArrayWrapper<DIGlobalVariable>(GlobalVariables), new MDTupleTypedArrayWrapper<DIImportedEntity>(ImportedEntities), new MDTupleTypedArrayWrapper<DIMacroNode>(Macros), DWOId, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1048,
   FQN="llvm::DICompileUnit::getTemporary", NM="_ZN4llvm13DICompileUnit12getTemporaryERNS_11LLVMContextEjPNS_6DIFileENS_9StringRefEbS5_jS5_NS0_17DebugEmissionKindENS_24MDTupleTypedArrayWrapperINS_15DICompositeTypeEEENS7_INS_7DIScopeEEENS7_INS_16DIGlobalVariableEEENS7_INS_16DIImportedEntityEEENS7_INS_11DIMacroNodeEEEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnit12getTemporaryERNS_11LLVMContextEjPNS_6DIFileENS_9StringRefEbS5_jS5_NS0_17DebugEmissionKindENS_24MDTupleTypedArrayWrapperINS_15DICompositeTypeEEENS7_INS_7DIScopeEEENS7_INS_16DIGlobalVariableEEENS7_INS_16DIImportedEntityEEENS7_INS_11DIMacroNodeEEEy")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DICompileUnit /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int SourceLanguage, DIFile /*P*/ File, StringRef Producer, boolean IsOptimized, StringRef Flags, /*uint*/int RuntimeVersion, StringRef SplitDebugFilename, DebugEmissionKind EmissionKind, MDTupleTypedArrayWrapper<DICompositeType> EnumTypes, MDTupleTypedArrayWrapper<DIScope> RetainedTypes, MDTupleTypedArrayWrapper<DIGlobalVariable> GlobalVariables, MDTupleTypedArrayWrapper<DIImportedEntity> ImportedEntities, MDTupleTypedArrayWrapper<DIMacroNode> Macros, long/*uint64_t*/ DWOId) {
    return new std.unique_ptr_with_deleter<DICompileUnit /*, TempMDNodeDeleter*/>(DICompileUnit.getImpl(Context, SourceLanguage, File, new StringRef(Producer), IsOptimized, new StringRef(Flags), RuntimeVersion, new StringRef(SplitDebugFilename), EmissionKind.getValue(), new MDTupleTypedArrayWrapper<DICompositeType>(EnumTypes), new MDTupleTypedArrayWrapper<DIScope>(RetainedTypes), new MDTupleTypedArrayWrapper<DIGlobalVariable>(GlobalVariables), new MDTupleTypedArrayWrapper<DIImportedEntity>(ImportedEntities), new MDTupleTypedArrayWrapper<DIMacroNode>(Macros), DWOId, StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1060,
   FQN="llvm::DICompileUnit::getDistinct", NM="_ZN4llvm13DICompileUnit11getDistinctERNS_11LLVMContextEjPNS_8MetadataEPNS_8MDStringEbS6_jS6_jS4_S4_S4_S4_S4_y",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnit11getDistinctERNS_11LLVMContextEjPNS_8MetadataEPNS_8MDStringEbS6_jS6_jS4_S4_S4_S4_S4_y")
  //</editor-fold>
  public static DICompileUnit /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int SourceLanguage, Metadata /*P*/ File, MDString /*P*/ Producer, boolean IsOptimized, MDString /*P*/ Flags, /*uint*/int RuntimeVersion, MDString /*P*/ SplitDebugFilename, /*uint*/int EmissionKind, Metadata /*P*/ EnumTypes, Metadata /*P*/ RetainedTypes, Metadata /*P*/ GlobalVariables, Metadata /*P*/ ImportedEntities, Metadata /*P*/ Macros, long/*uint64_t*/ DWOId) {
    return getImpl(Context, SourceLanguage, File, Producer, IsOptimized, Flags, RuntimeVersion, SplitDebugFilename, EmissionKind, EnumTypes, RetainedTypes, GlobalVariables, ImportedEntities, Macros, DWOId, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1060,
   FQN="llvm::DICompileUnit::getTemporary", NM="_ZN4llvm13DICompileUnit12getTemporaryERNS_11LLVMContextEjPNS_8MetadataEPNS_8MDStringEbS6_jS6_jS4_S4_S4_S4_S4_y",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnit12getTemporaryERNS_11LLVMContextEjPNS_8MetadataEPNS_8MDStringEbS6_jS6_jS4_S4_S4_S4_S4_y")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DICompileUnit /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int SourceLanguage, Metadata /*P*/ File, MDString /*P*/ Producer, boolean IsOptimized, MDString /*P*/ Flags, /*uint*/int RuntimeVersion, MDString /*P*/ SplitDebugFilename, /*uint*/int EmissionKind, Metadata /*P*/ EnumTypes, Metadata /*P*/ RetainedTypes, Metadata /*P*/ GlobalVariables, Metadata /*P*/ ImportedEntities, Metadata /*P*/ Macros, long/*uint64_t*/ DWOId) {
    return new std.unique_ptr_with_deleter<DICompileUnit /*, TempMDNodeDeleter*/>(getImpl(Context, SourceLanguage, File, Producer, IsOptimized, Flags, RuntimeVersion, SplitDebugFilename, EmissionKind, EnumTypes, RetainedTypes, GlobalVariables, ImportedEntities, Macros, DWOId, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1071,
   FQN="llvm::DICompileUnit::clone", NM="_ZNK4llvm13DICompileUnit5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DICompileUnit /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getSourceLanguage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1073,
   FQN="llvm::DICompileUnit::getSourceLanguage", NM="_ZNK4llvm13DICompileUnit17getSourceLanguageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit17getSourceLanguageEv")
  //</editor-fold>
  public /*uint*/int getSourceLanguage() /*const*/ {
    return SourceLanguage;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::isOptimized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1074,
   FQN="llvm::DICompileUnit::isOptimized", NM="_ZNK4llvm13DICompileUnit11isOptimizedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit11isOptimizedEv")
  //</editor-fold>
  public boolean isOptimized() /*const*/ {
    return IsOptimized;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getRuntimeVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1075,
   FQN="llvm::DICompileUnit::getRuntimeVersion", NM="_ZNK4llvm13DICompileUnit17getRuntimeVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit17getRuntimeVersionEv")
  //</editor-fold>
  public /*uint*/int getRuntimeVersion() /*const*/ {
    return RuntimeVersion;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getEmissionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1076,
   FQN="llvm::DICompileUnit::getEmissionKind", NM="_ZNK4llvm13DICompileUnit15getEmissionKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit15getEmissionKindEv")
  //</editor-fold>
  public DebugEmissionKind getEmissionKind() /*const*/ {
    return DebugEmissionKind.valueOf(EmissionKind);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getProducer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1079,
   FQN="llvm::DICompileUnit::getProducer", NM="_ZNK4llvm13DICompileUnit11getProducerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit11getProducerEv")
  //</editor-fold>
  public StringRef getProducer() /*const*/ {
    return getStringOperand(1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1080,
   FQN="llvm::DICompileUnit::getFlags", NM="_ZNK4llvm13DICompileUnit8getFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit8getFlagsEv")
  //</editor-fold>
  public StringRef getFlags() /*const*/ {
    return getStringOperand(2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getSplitDebugFilename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1081,
   FQN="llvm::DICompileUnit::getSplitDebugFilename", NM="_ZNK4llvm13DICompileUnit21getSplitDebugFilenameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit21getSplitDebugFilenameEv")
  //</editor-fold>
  public StringRef getSplitDebugFilename() /*const*/ {
    return getStringOperand(3);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getEnumTypes">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1082,
   FQN="llvm::DICompileUnit::getEnumTypes", NM="_ZNK4llvm13DICompileUnit12getEnumTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit12getEnumTypesEv")
  //</editor-fold>
  public MDTupleTypedArrayWrapper<DICompositeType> getEnumTypes() /*const*/ {
    return new MDTupleTypedArrayWrapper<DICompositeType>(DICompositeType.class, cast_or_null_MDTuple(getRawEnumTypes()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getRetainedTypes">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1085,
   FQN="llvm::DICompileUnit::getRetainedTypes", NM="_ZNK4llvm13DICompileUnit16getRetainedTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit16getRetainedTypesEv")
  //</editor-fold>
  public MDTupleTypedArrayWrapper<DIScope> getRetainedTypes() /*const*/ {
    return new MDTupleTypedArrayWrapper<DIScope>(DIScope.class, cast_or_null_MDTuple(getRawRetainedTypes()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getGlobalVariables">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1088,
   FQN="llvm::DICompileUnit::getGlobalVariables", NM="_ZNK4llvm13DICompileUnit18getGlobalVariablesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit18getGlobalVariablesEv")
  //</editor-fold>
  public MDTupleTypedArrayWrapper<DIGlobalVariable> getGlobalVariables() /*const*/ {
    return new MDTupleTypedArrayWrapper<DIGlobalVariable>(DIGlobalVariable.class, cast_or_null_MDTuple(getRawGlobalVariables()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getImportedEntities">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1091,
   FQN="llvm::DICompileUnit::getImportedEntities", NM="_ZNK4llvm13DICompileUnit19getImportedEntitiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit19getImportedEntitiesEv")
  //</editor-fold>
  public MDTupleTypedArrayWrapper<DIImportedEntity> getImportedEntities() /*const*/ {
    return new MDTupleTypedArrayWrapper<DIImportedEntity>(DIImportedEntity.class, cast_or_null_MDTuple(getRawImportedEntities()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getMacros">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1094,
   FQN="llvm::DICompileUnit::getMacros", NM="_ZNK4llvm13DICompileUnit9getMacrosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit9getMacrosEv")
  //</editor-fold>
  public MDTupleTypedArrayWrapper<DIMacroNode> getMacros() /*const*/ {
    return new MDTupleTypedArrayWrapper<DIMacroNode>(DIMacroNode.class, cast_or_null_MDTuple(getRawMacros()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getDWOId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1097,
   FQN="llvm::DICompileUnit::getDWOId", NM="_ZNK4llvm13DICompileUnit8getDWOIdEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit8getDWOIdEv")
  //</editor-fold>
  public long/*uint64_t*/ getDWOId() /*const*/ {
    return DWOId;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::setDWOId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1098,
   FQN="llvm::DICompileUnit::setDWOId", NM="_ZN4llvm13DICompileUnit8setDWOIdEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnit8setDWOIdEy")
  //</editor-fold>
  public void setDWOId(long/*uint64_t*/ DwoId) {
    DWOId = DwoId;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getRawProducer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1100,
   FQN="llvm::DICompileUnit::getRawProducer", NM="_ZNK4llvm13DICompileUnit14getRawProducerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit14getRawProducerEv")
  //</editor-fold>
  public MDString /*P*/ getRawProducer() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getRawFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1101,
   FQN="llvm::DICompileUnit::getRawFlags", NM="_ZNK4llvm13DICompileUnit11getRawFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit11getRawFlagsEv")
  //</editor-fold>
  public MDString /*P*/ getRawFlags() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getRawSplitDebugFilename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1102,
   FQN="llvm::DICompileUnit::getRawSplitDebugFilename", NM="_ZNK4llvm13DICompileUnit24getRawSplitDebugFilenameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit24getRawSplitDebugFilenameEv")
  //</editor-fold>
  public MDString /*P*/ getRawSplitDebugFilename() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 3);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getRawEnumTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1105,
   FQN="llvm::DICompileUnit::getRawEnumTypes", NM="_ZNK4llvm13DICompileUnit15getRawEnumTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit15getRawEnumTypesEv")
  //</editor-fold>
  public Metadata /*P*/ getRawEnumTypes() /*const*/ {
    return getOperand(4).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getRawRetainedTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1106,
   FQN="llvm::DICompileUnit::getRawRetainedTypes", NM="_ZNK4llvm13DICompileUnit19getRawRetainedTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit19getRawRetainedTypesEv")
  //</editor-fold>
  public Metadata /*P*/ getRawRetainedTypes() /*const*/ {
    return getOperand(5).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getRawGlobalVariables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1107,
   FQN="llvm::DICompileUnit::getRawGlobalVariables", NM="_ZNK4llvm13DICompileUnit21getRawGlobalVariablesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit21getRawGlobalVariablesEv")
  //</editor-fold>
  public Metadata /*P*/ getRawGlobalVariables() /*const*/ {
    return getOperand(6).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getRawImportedEntities">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1108,
   FQN="llvm::DICompileUnit::getRawImportedEntities", NM="_ZNK4llvm13DICompileUnit22getRawImportedEntitiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit22getRawImportedEntitiesEv")
  //</editor-fold>
  public Metadata /*P*/ getRawImportedEntities() /*const*/ {
    return getOperand(7).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::getRawMacros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1109,
   FQN="llvm::DICompileUnit::getRawMacros", NM="_ZNK4llvm13DICompileUnit12getRawMacrosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DICompileUnit12getRawMacrosEv")
  //</editor-fold>
  public Metadata /*P*/ getRawMacros() /*const*/ {
    return getOperand(8).$Metadata$P();
  }


  /// \brief Replace arrays.
  ///
  /// If this \a isUniqued() and not \a isResolved(), it will be RAUW'ed and
  /// deleted on a uniquing collision.  In practice, uniquing collisions on \a
  /// DICompileUnit should be fairly rare.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::replaceEnumTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1117,
   FQN="llvm::DICompileUnit::replaceEnumTypes", NM="_ZN4llvm13DICompileUnit16replaceEnumTypesENS_24MDTupleTypedArrayWrapperINS_15DICompositeTypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnit16replaceEnumTypesENS_24MDTupleTypedArrayWrapperINS_15DICompositeTypeEEE")
  //</editor-fold>
  public void replaceEnumTypes(MDTupleTypedArrayWrapper<DICompositeType> N) {
    replaceOperandWith(4, N.get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::replaceRetainedTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1120,
   FQN="llvm::DICompileUnit::replaceRetainedTypes", NM="_ZN4llvm13DICompileUnit20replaceRetainedTypesENS_24MDTupleTypedArrayWrapperINS_6DITypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnit20replaceRetainedTypesENS_24MDTupleTypedArrayWrapperINS_6DITypeEEE")
  //</editor-fold>
  public void replaceRetainedTypes(MDTupleTypedArrayWrapper<DIType> N) {
    replaceOperandWith(5, N.get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::replaceGlobalVariables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1123,
   FQN="llvm::DICompileUnit::replaceGlobalVariables", NM="_ZN4llvm13DICompileUnit22replaceGlobalVariablesENS_24MDTupleTypedArrayWrapperINS_16DIGlobalVariableEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnit22replaceGlobalVariablesENS_24MDTupleTypedArrayWrapperINS_16DIGlobalVariableEEE")
  //</editor-fold>
  public void replaceGlobalVariables(MDTupleTypedArrayWrapper<DIGlobalVariable> N) {
    replaceOperandWith(6, N.get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::replaceImportedEntities">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1126,
   FQN="llvm::DICompileUnit::replaceImportedEntities", NM="_ZN4llvm13DICompileUnit23replaceImportedEntitiesENS_24MDTupleTypedArrayWrapperINS_16DIImportedEntityEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnit23replaceImportedEntitiesENS_24MDTupleTypedArrayWrapperINS_16DIImportedEntityEEE")
  //</editor-fold>
  public void replaceImportedEntities(MDTupleTypedArrayWrapper<DIImportedEntity> N) {
    replaceOperandWith(7, N.get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::replaceMacros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1129,
   FQN="llvm::DICompileUnit::replaceMacros", NM="_ZN4llvm13DICompileUnit13replaceMacrosENS_24MDTupleTypedArrayWrapperINS_11DIMacroNodeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnit13replaceMacrosENS_24MDTupleTypedArrayWrapperINS_11DIMacroNodeEEE")
  //</editor-fold>
  public void replaceMacros(MDTupleTypedArrayWrapper<DIMacroNode> N) {
    replaceOperandWith(8, N.get());
  }

  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::DICompileUnit::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1132,
   FQN="llvm::DICompileUnit::classof", NM="_ZN4llvm13DICompileUnit7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DICompileUnit7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DICompileUnitKind.getValue();
  }


  @Override public String toString() {
    return "" + "SourceLanguage=" + SourceLanguage // NOI18N
              + ", IsOptimized=" + IsOptimized // NOI18N
              + ", RuntimeVersion=" + RuntimeVersion // NOI18N
              + ", EmissionKind=" + EmissionKind // NOI18N
              + ", DWOId=" + DWOId // NOI18N
              + super.toString(); // NOI18N
  }
}

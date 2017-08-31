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
import static org.clank.support.CollectionUtils.transform_long2ulong$ptr;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.support.dwarf.Tag;
import static org.llvm.ir.intrinsic.IntrinsicGlobals.getDeclaration;
import org.llvm.support.dwarf.LocationAtom;
import org.llvm.support.dwarf.SourceLanguage;

//<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DIBuilder.h", line = 34,
 FQN="llvm::DIBuilder", NM="_ZN4llvm9DIBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilderE")
//</editor-fold>
public class DIBuilder implements Destructors.ClassWithDestructor {
  private final Module /*&*/ M;
  private final LLVMContext /*&*/ VMContext;

  private DICompileUnit /*P*/ CUNode; ///< The one compile unit created by this DIBuiler.
  private Function /*P*/ DeclareFn; ///< llvm.dbg.declare
  private Function /*P*/ ValueFn; ///< llvm.dbg.value

  private SmallVector<Metadata /*P*/ > AllEnumTypes;
  /// Track the RetainTypes, since they can be updated later on.
  private SmallVector<TypedTrackingMDRef<MDNode>> AllRetainTypes;
  private SmallVector<Metadata /*P*/ > AllSubprograms;
  private SmallVector<Metadata /*P*/ > AllGVs;
  private SmallVector<TypedTrackingMDRef<MDNode>> AllImportedModules;

  /// Track nodes that may be unresolved.
  private SmallVector<TypedTrackingMDRef<MDNode>> UnresolvedNodes;
  private boolean AllowUnresolvedNodes;

  /// Each subprogram's preserved local variables.
  ///
  /// Do not use a std::vector.  Some versions of libc++ apparently copy
  /// instead of move on grow operations, and TrackingMDRef is expensive to
  /// copy.
  private DenseMap<MDNode /*P*/ , SmallVector<TypedTrackingMDRef<MDNode>>> PreservedVariables;

  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::DIBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DIBuilder.h", line = 60,
   FQN="llvm::DIBuilder::DIBuilder", NM="_ZN4llvm9DIBuilderC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilderC1ERKS0_")
  //</editor-fold>
  protected/*private*/ DIBuilder(final /*const*/ DIBuilder /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DIBuilder.h", line = 61,
   FQN="llvm::DIBuilder::operator=", NM="_ZN4llvm9DIBuilderaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilderaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ DIBuilder /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}


  /// Create a temporary.
  ///
  /// Create an \a temporary node and track it in \a UnresolvedNodes.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::trackIfUnresolved">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 32,
   FQN="llvm::DIBuilder::trackIfUnresolved", NM="_ZN4llvm9DIBuilder17trackIfUnresolvedEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder17trackIfUnresolvedEPNS_6MDNodeE")
  //</editor-fold>
  private void trackIfUnresolved(MDNode /*P*/ N) {
    if (!(N != null)) {
      return;
    }
    if (N.isResolved()) {
      return;
    }
    assert (AllowUnresolvedNodes) : "Cannot handle unresolved nodes";
    UnresolvedNodes.emplace_back(new TypedTrackingMDRef<MDNode>(N));
  }

/*public:*/
  /// Construct a builder for a module.
  ///
  /// If \c AllowUnresolved, collect unresolved nodes attached to the module
  /// in order to resolve cycles during \a finalize().
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::DIBuilder">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 27,
   FQN="llvm::DIBuilder::DIBuilder", NM="_ZN4llvm9DIBuilderC1ERNS_6ModuleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilderC1ERNS_6ModuleEb")
  //</editor-fold>
  public DIBuilder(final Module /*&*/ m) {
    this(m, true);
  }
  public DIBuilder(final Module /*&*/ m, boolean AllowUnresolvedNodes/*= true*/) {
    // : M(m), VMContext(M.getContext()), CUNode(null), DeclareFn(null), ValueFn(null), AllEnumTypes(), AllRetainTypes(), AllSubprograms(), AllGVs(), AllImportedModules(), UnresolvedNodes(), AllowUnresolvedNodes(AllowUnresolvedNodes), PreservedVariables()
    //START JInit
    this./*&*/M=/*&*/m;
    this./*&*/VMContext=/*&*/M.getContext();
    this.CUNode = null;
    this.DeclareFn = null;
    this.ValueFn = null;
    this.AllEnumTypes = new SmallVector<Metadata /*P*/ >(4, (Metadata /*P*/ )null);
    this.AllRetainTypes = new SmallVector<TypedTrackingMDRef<MDNode>>(4, new TypedTrackingMDRef<MDNode>());
    this.AllSubprograms = new SmallVector<Metadata /*P*/ >(4, (Metadata /*P*/ )null);
    this.AllGVs = new SmallVector<Metadata /*P*/ >(4, (Metadata /*P*/ )null);
    this.AllImportedModules = new SmallVector<TypedTrackingMDRef<MDNode>>(4, new TypedTrackingMDRef<MDNode>());
    this.UnresolvedNodes = new SmallVector<TypedTrackingMDRef<MDNode>>(4, new TypedTrackingMDRef<MDNode>());
    this.AllowUnresolvedNodes = AllowUnresolvedNodes;
    this.PreservedVariables = new DenseMap<MDNode /*P*/ , SmallVector<TypedTrackingMDRef<MDNode>>>(DenseMapInfo$LikePtr.$Info(), new SmallVector<TypedTrackingMDRef<MDNode>>(1, new TypedTrackingMDRef<MDNode>()));
    //END JInit
  }


  /// Construct any deferred debug info descriptors.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::finalize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 42,
   FQN="llvm::DIBuilder::finalize", NM="_ZN4llvm9DIBuilder8finalizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder8finalizeEv")
  //</editor-fold>
  public void finalize() {
    if (!(CUNode != null)) {
      assert (!AllowUnresolvedNodes) : "creating type nodes without a CU is not supported";
      return;
    }

    CUNode.replaceEnumTypes(new MDTupleTypedArrayWrapper<DICompositeType>(DICompositeType.class, MDTuple.get(VMContext, new ArrayRef<Metadata /*P*/ >(AllEnumTypes, true))));

    SmallVector<Metadata /*P*/ > RetainValues/*J*/= new SmallVector<Metadata /*P*/ >(16, (Metadata /*P*/ )null);
    // Declarations and definitions of the same type may be retained. Some
    // clients RAUW these pairs, leaving duplicates in the retained types
    // list. Use a set to remove the duplicates while we transform the
    // TrackingVHs back into Values.
    SmallPtrSet<Metadata /*P*/ > RetainSet/*J*/= new SmallPtrSet<Metadata /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    for (/*uint*/int I = 0, E = AllRetainTypes.size(); $less_uint(I, E); I++)  {
      if (RetainSet.insert(AllRetainTypes.$at(I).$T$P()).second) {
        RetainValues.push_back(AllRetainTypes.$at(I).$T$P());
      }
    }
    if (!RetainValues.empty()) {
      CUNode.replaceRetainedTypes(new MDTupleTypedArrayWrapper<DIType>(DIType.class, MDTuple.get(VMContext, new ArrayRef<Metadata /*P*/ >(RetainValues, true))));
    }

    MDTupleTypedArrayWrapper<DISubprogram> SPs = new MDTupleTypedArrayWrapper<DISubprogram>(DISubprogram.class, MDTuple.get(VMContext, new ArrayRef<Metadata /*P*/ >(AllSubprograms, true)));
    DISubprogram2Void resolveVariables = /*[&, this]*/ (DISubprogram /*P*/ SP) -> {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            MDTuple /*P*/ Temp = SP.getVariables().get();
            if (!(Temp != null)) {
              return;
            }

            SmallVector<Metadata /*P*/ > Variables/*J*/= new SmallVector<Metadata /*P*/ >(4, (Metadata /*P*/ )null);

            DenseMapIterator<MDNode /*P*/ , SmallVector<TypedTrackingMDRef<MDNode>>> PV = PreservedVariables.find(SP);
            if (PV.$noteq(/*NO_ITER_COPY*/PreservedVariables.end())) {
              Variables.append_T(PV.$arrow().second.begin(), PV.$arrow().second.end(), (TypedTrackingMDRef<MDNode> R) -> R.$arrow());
            }

            MDTupleTypedArrayWrapper<DINode> AV = getOrCreateArray(new ArrayRef<Metadata /*P*/ >(Variables, true));
            $c$.track(new std.unique_ptr_with_deleter<MDTuple /*, TempMDNodeDeleter*/>(Temp)).$arrow().replaceAllUsesWith(AV.get()); $c$.clean();
          } finally {
            $c$.$destroy();
          }
        };
    for (DISubprogram /*P*/ SP : SPs)  {
      resolveVariables.$call(SP);
    }
    for (Metadata /*P*/ N : RetainValues)  {
      {
        DISubprogram /*P*/ SP = dyn_cast_DISubprogram(N);
        if ((SP != null)) {
          resolveVariables.$call(SP);
        }
      }
    }
    if (!AllGVs.empty()) {
      CUNode.replaceGlobalVariables(new MDTupleTypedArrayWrapper<DIGlobalVariable>(DIGlobalVariable.class, MDTuple.get(VMContext, new ArrayRef<Metadata /*P*/ >(AllGVs, true))));
    }
    if (!AllImportedModules.empty()) {
      CUNode.replaceImportedEntities(new MDTupleTypedArrayWrapper<DIImportedEntity>(DIImportedEntity.class, MDTuple.get(VMContext, new ArrayRef<Metadata /*P*/ >(new SmallVector<Metadata /*P*/ >(JD$T.INSTANCE, 16, AllImportedModules.begin(),
                          AllImportedModules.end(), (Metadata /*P*/ )null, (TypedTrackingMDRef<MDNode> R) -> R.$arrow()), true))));
    }

    // Now that all temp nodes have been replaced or deleted, resolve remaining
    // cycles.
    for (final /*const*/ TypedTrackingMDRef<MDNode> /*&*/ N : UnresolvedNodes)  {
      if (((N.$T$P()) != null) && !N.$arrow().isResolved()) {
        N.$arrow().resolveCycles();
      }
    }
    UnresolvedNodes.clear();

    // Can't handle unresolved nodes anymore.
    AllowUnresolvedNodes = false;
  }


  /// A CompileUnit provides an anchor for all debugging
  /// information generated during this instance of compilation.
  /// \param Lang          Source programming language, eg. dwarf::DW_LANG_C99
  /// \param File          File name
  /// \param Dir           Directory
  /// \param Producer      Identify the producer of debugging information
  ///                      and code.  Usually this is a compiler
  ///                      version string.
  /// \param isOptimized   A boolean flag which indicates whether optimization
  ///                      is enabled or not.
  /// \param Flags         This string lists command line options. This
  ///                      string is directly embedded in debug info
  ///                      output which may be used by a tool
  ///                      analyzing generated debugging information.
  /// \param RV            This indicates runtime version for languages like
  ///                      Objective-C.
  /// \param SplitName     The name of the file that we'll split debug info
  ///                      out into.
  /// \param Kind          The kind of debug information to generate.
  /// \param DWOId         The DWOId if this is a split skeleton compile unit.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createCompileUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 111,
   FQN="llvm::DIBuilder::createCompileUnit", NM="_ZN4llvm9DIBuilder17createCompileUnitEjNS_9StringRefES1_S1_bS1_jS1_NS_13DICompileUnit17DebugEmissionKindEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder17createCompileUnitEjNS_9StringRefES1_S1_bS1_jS1_NS_13DICompileUnit17DebugEmissionKindEy")
  //</editor-fold>
  public DICompileUnit /*P*/ createCompileUnit(/*uint*/int Lang, StringRef Filename, StringRef Directory, StringRef Producer,
                   boolean isOptimized, StringRef Flags, /*uint*/int RunTimeVer) {
    return createCompileUnit(Lang, Filename, Directory, Producer,
                   isOptimized, Flags, RunTimeVer, new StringRef(),
                   DICompileUnit.DebugEmissionKind.FullDebug, $int2ulong(0));
  }
  public DICompileUnit /*P*/ createCompileUnit(/*uint*/int Lang, StringRef Filename, StringRef Directory, StringRef Producer,
                   boolean isOptimized, StringRef Flags, /*uint*/int RunTimeVer, StringRef SplitName/*= StringRef()*/) {
    return createCompileUnit(Lang, Filename, Directory, Producer,
                   isOptimized, Flags, RunTimeVer, SplitName,
                   DICompileUnit.DebugEmissionKind.FullDebug, $int2ulong(0));
  }
  public DICompileUnit /*P*/ createCompileUnit(/*uint*/int Lang, StringRef Filename, StringRef Directory, StringRef Producer,
                   boolean isOptimized, StringRef Flags, /*uint*/int RunTimeVer, StringRef SplitName/*= StringRef()*/,
                   DICompileUnit.DebugEmissionKind Kind/*= DICompileUnit::DebugEmissionKind::FullDebug*/) {
    return createCompileUnit(Lang, Filename, Directory, Producer,
                   isOptimized, Flags, RunTimeVer, SplitName,
                   Kind, $int2ulong(0));
  }
  public DICompileUnit /*P*/ createCompileUnit(/*uint*/int Lang, StringRef Filename, StringRef Directory, StringRef Producer,
                   boolean isOptimized, StringRef Flags, /*uint*/int RunTimeVer, StringRef SplitName/*= StringRef()*/,
                   DICompileUnit.DebugEmissionKind Kind/*= DICompileUnit::DebugEmissionKind::FullDebug*/, long/*uint64_t*/ DWOId/*= 0*/) {
    assert ((($lesseq_uint(Lang, SourceLanguage.DW_LANG_Fortran08) && $greatereq_uint(Lang, SourceLanguage.DW_LANG_C89)) || ($lesseq_uint(Lang, SourceLanguage.DW_LANG_hi_user) && $greatereq_uint(Lang, SourceLanguage.DW_LANG_lo_user)))) : "Invalid Language tag";
    assert (!Filename.empty()) : "Unable to create compile unit without filename";
    assert (!(CUNode != null)) : "Can only make one compile unit per DIBuilder instance";
    CUNode = DICompileUnit.getDistinct(VMContext, Lang, DIFile.get(VMContext, new StringRef(Filename), new StringRef(Directory)), new StringRef(Producer),
        isOptimized, new StringRef(Flags), RunTimeVer, new StringRef(SplitName), Kind, new MDTupleTypedArrayWrapper<DICompositeType>(DICompositeType.class, (/*const*/ MDTuple /*P*/ )null), new MDTupleTypedArrayWrapper<DIScope>(DIScope.class, (/*const*/ MDTuple /*P*/ )null),
        new MDTupleTypedArrayWrapper<DIGlobalVariable>(DIGlobalVariable.class, (/*const*/ MDTuple /*P*/ )null), new MDTupleTypedArrayWrapper<DIImportedEntity>(DIImportedEntity.class, (/*const*/ MDTuple /*P*/ )null), new MDTupleTypedArrayWrapper<DIMacroNode>(DIMacroNode.class, (/*const*/ MDTuple /*P*/ )null), DWOId);

    // Create a named metadata so that it is easier to find cu in a module.
    NamedMDNode /*P*/ NMD = M.getOrInsertNamedMetadata(new StringRef(/*KEEP_STR*/"llvm.dbg.cu"));
    NMD.addOperand(CUNode);
    trackIfUnresolved(CUNode);
    return CUNode;
  }


  /// Create a file descriptor to hold debugging information
  /// for a file.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 178,
   FQN="llvm::DIBuilder::createFile", NM="_ZN4llvm9DIBuilder10createFileENS_9StringRefES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder10createFileENS_9StringRefES1_")
  //</editor-fold>
  public DIFile /*P*/ createFile(StringRef Filename, StringRef Directory) {
    return DIFile.get(VMContext, new StringRef(Filename), new StringRef(Directory));
  }


  /// Create a single enumerator value.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createEnumerator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 182,
   FQN="llvm::DIBuilder::createEnumerator", NM="_ZN4llvm9DIBuilder16createEnumeratorENS_9StringRefEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder16createEnumeratorENS_9StringRefEx")
  //</editor-fold>
  public DIEnumerator /*P*/ createEnumerator(StringRef Name, long/*int64_t*/ Val) {
    assert (!Name.empty()) : "Unable to create enumerator without name";
    return DIEnumerator.get(VMContext, Val, new StringRef(Name));
  }


  /// Create a DWARF unspecified type.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createUnspecifiedType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 187,
   FQN="llvm::DIBuilder::createUnspecifiedType", NM="_ZN4llvm9DIBuilder21createUnspecifiedTypeENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder21createUnspecifiedTypeENS_9StringRefE")
  //</editor-fold>
  public DIBasicType /*P*/ createUnspecifiedType(StringRef Name) {
    assert (!Name.empty()) : "Unable to create type without name";
    return DIBasicType.get(VMContext, $ushort2uint(Tag.DW_TAG_unspecified_type), new StringRef(Name));
  }


  /// Create C++11 nullptr type.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createNullPtrType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 192,
   FQN="llvm::DIBuilder::createNullPtrType", NM="_ZN4llvm9DIBuilder17createNullPtrTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder17createNullPtrTypeEv")
  //</editor-fold>
  public DIBasicType /*P*/ createNullPtrType() {
    return createUnspecifiedType(new StringRef(/*KEEP_STR*/"decltype(nullptr)"));
  }


  /// Create debugging information entry for a basic
  /// type.
  /// \param Name        Type name.
  /// \param SizeInBits  Size of the type.
  /// \param AlignInBits Type alignment.
  /// \param Encoding    DWARF encoding code, e.g. dwarf::DW_ATE_float.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createBasicType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 196,
   FQN="llvm::DIBuilder::createBasicType", NM="_ZN4llvm9DIBuilder15createBasicTypeENS_9StringRefEyyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder15createBasicTypeENS_9StringRefEyyj")
  //</editor-fold>
  public DIBasicType /*P*/ createBasicType(StringRef Name, long/*uint64_t*/ SizeInBits,
                 long/*uint64_t*/ AlignInBits,
                 /*uint*/int Encoding) {
    assert (!Name.empty()) : "Unable to create type without name";
    return DIBasicType.get(VMContext, $ushort2uint(Tag.DW_TAG_base_type), new StringRef(Name), SizeInBits,
        AlignInBits, Encoding);
  }


  /// Create debugging information entry for a qualified
  /// type, e.g. 'const int'.
  /// \param Tag         Tag identifing type, e.g. dwarf::TAG_volatile_type
  /// \param FromTy      Base Type.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createQualifiedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 204,
   FQN="llvm::DIBuilder::createQualifiedType", NM="_ZN4llvm9DIBuilder19createQualifiedTypeEjPNS_6DITypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder19createQualifiedTypeEjPNS_6DITypeE")
  //</editor-fold>
  public DIDerivedType /*P*/ createQualifiedType(/*uint*/int Tag, DIType /*P*/ FromTy) {
    return DIDerivedType.get(VMContext, Tag, new StringRef(/*KEEP_STR*/$EMPTY), (DIFile /*P*/ )null, 0, new TypedDINodeRef<DIScope>(DIScope.class, JD$NullPtr.INSTANCE, null), new TypedDINodeRef<DIType>(DIType.class, FromTy), $int2ulong(0),
        $int2ulong(0), $int2ulong(0), 0);
  }


  /// Create debugging information entry for a pointer.
  /// \param PointeeTy   Type pointed by this pointer.
  /// \param SizeInBits  Size.
  /// \param AlignInBits Alignment. (optional)
  /// \param Name        Pointer type name. (optional)
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 209,
   FQN="llvm::DIBuilder::createPointerType", NM="_ZN4llvm9DIBuilder17createPointerTypeEPNS_6DITypeEyyNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder17createPointerTypeEPNS_6DITypeEyyNS_9StringRefE")
  //</editor-fold>
  public DIDerivedType /*P*/ createPointerType(DIType /*P*/ PointeeTy,
                   long/*uint64_t*/ SizeInBits) {
    return createPointerType(PointeeTy,
                   SizeInBits,
                   $int2ulong(0),
                   new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DIDerivedType /*P*/ createPointerType(DIType /*P*/ PointeeTy,
                   long/*uint64_t*/ SizeInBits,
                   long/*uint64_t*/ AlignInBits/*= 0*/) {
    return createPointerType(PointeeTy,
                   SizeInBits,
                   AlignInBits,
                   new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DIDerivedType /*P*/ createPointerType(DIType /*P*/ PointeeTy,
                   long/*uint64_t*/ SizeInBits,
                   long/*uint64_t*/ AlignInBits/*= 0*/,
                   StringRef Name/*= ""*/) {
    // FIXME: Why is there a name here?
    return DIDerivedType.get(VMContext, $ushort2uint(Tag.DW_TAG_pointer_type), new StringRef(Name),
        (DIFile /*P*/ )null, 0, new TypedDINodeRef<DIScope>(DIScope.class, JD$NullPtr.INSTANCE, null), new TypedDINodeRef<DIType>(DIType.class, PointeeTy), SizeInBits,
        AlignInBits, $int2ulong(0), 0);
  }


  /// Create debugging information entry for a pointer to member.
  /// \param PointeeTy Type pointed to by this pointer.
  /// \param SizeInBits  Size.
  /// \param AlignInBits Alignment. (optional)
  /// \param Class Type for which this pointer points to members of.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createMemberPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 219,
   FQN="llvm::DIBuilder::createMemberPointerType", NM="_ZN4llvm9DIBuilder23createMemberPointerTypeEPNS_6DITypeES2_yyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder23createMemberPointerTypeEPNS_6DITypeES2_yyj")
  //</editor-fold>
  public DIDerivedType /*P*/ createMemberPointerType(DIType /*P*/ PointeeTy,
                         DIType /*P*/ Base,
                         long/*uint64_t*/ SizeInBits) {
    return createMemberPointerType(PointeeTy,
                         Base,
                         SizeInBits,
                         $int2ulong(0),
                         0);
  }
  public DIDerivedType /*P*/ createMemberPointerType(DIType /*P*/ PointeeTy,
                         DIType /*P*/ Base,
                         long/*uint64_t*/ SizeInBits,
                         long/*uint64_t*/ AlignInBits/*= 0*/) {
    return createMemberPointerType(PointeeTy,
                         Base,
                         SizeInBits,
                         AlignInBits,
                         0);
  }
  public DIDerivedType /*P*/ createMemberPointerType(DIType /*P*/ PointeeTy,
                         DIType /*P*/ Base,
                         long/*uint64_t*/ SizeInBits,
                         long/*uint64_t*/ AlignInBits/*= 0*/,
                         /*uint*/int Flags/*= 0*/) {
    return DIDerivedType.get(VMContext, $ushort2uint(Tag.DW_TAG_ptr_to_member_type), new StringRef(/*KEEP_STR*/$EMPTY),
        (DIFile /*P*/ )null, 0, new TypedDINodeRef<DIScope>(DIScope.class, JD$NullPtr.INSTANCE, null), new TypedDINodeRef<DIType>(DIType.class, PointeeTy), SizeInBits,
        AlignInBits, $int2ulong(0), Flags, Base);
  }


  /// Create debugging information entry for a c++
  /// style reference or rvalue reference type.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 229,
   FQN="llvm::DIBuilder::createReferenceType", NM="_ZN4llvm9DIBuilder19createReferenceTypeEjPNS_6DITypeEyy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder19createReferenceTypeEjPNS_6DITypeEyy")
  //</editor-fold>
  public DIDerivedType /*P*/ createReferenceType(/*uint*/int Tag, DIType /*P*/ RTy) {
    return createReferenceType(Tag, RTy,
                     $int2ulong(0),
                     $int2ulong(0));
  }
  public DIDerivedType /*P*/ createReferenceType(/*uint*/int Tag, DIType /*P*/ RTy,
                     long/*uint64_t*/ SizeInBits/*= 0*/) {
    return createReferenceType(Tag, RTy,
                     SizeInBits,
                     $int2ulong(0));
  }
  public DIDerivedType /*P*/ createReferenceType(/*uint*/int Tag, DIType /*P*/ RTy,
                     long/*uint64_t*/ SizeInBits/*= 0*/,
                     long/*uint64_t*/ AlignInBits/*= 0*/) {
    assert ((RTy != null)) : "Unable to create reference type";
    return DIDerivedType.get(VMContext, Tag, new StringRef(/*KEEP_STR*/$EMPTY), (DIFile /*P*/ )null, 0, new TypedDINodeRef<DIScope>(DIScope.class, JD$NullPtr.INSTANCE, null), new TypedDINodeRef<DIType>(DIType.class, RTy),
        SizeInBits, AlignInBits, $int2ulong(0), 0);
  }


  /// Create debugging information entry for a typedef.
  /// \param Ty          Original type.
  /// \param Name        Typedef name.
  /// \param File        File where this type is defined.
  /// \param LineNo      Line number.
  /// \param Context     The surrounding context for the typedef.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createTypedef">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 237,
   FQN="llvm::DIBuilder::createTypedef", NM="_ZN4llvm9DIBuilder13createTypedefEPNS_6DITypeENS_9StringRefEPNS_6DIFileEjPNS_7DIScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder13createTypedefEPNS_6DITypeENS_9StringRefEPNS_6DIFileEjPNS_7DIScopeE")
  //</editor-fold>
  public DIDerivedType /*P*/ createTypedef(DIType /*P*/ Ty, StringRef Name,
               DIFile /*P*/ File, /*uint*/int LineNo,
               DIScope /*P*/ Context) {
    return DIDerivedType.get(VMContext, $ushort2uint(Tag.DW_TAG_typedef), new StringRef(Name), File,
        LineNo, new TypedDINodeRef<DIScope>(DIScope.class, DIBuilderStatics.getNonCompileUnitScope(Context)), new TypedDINodeRef<DIType>(DIType.class, Ty), $int2ulong(0), $int2ulong(0),
        $int2ulong(0), 0);
  }


  /// Create debugging information entry for a 'friend'.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createFriend">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 245,
   FQN="llvm::DIBuilder::createFriend", NM="_ZN4llvm9DIBuilder12createFriendEPNS_6DITypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder12createFriendEPNS_6DITypeES2_")
  //</editor-fold>
  public DIDerivedType /*P*/ createFriend(DIType /*P*/ Ty, DIType /*P*/ FriendTy) {
    assert ((Ty != null)) : "Invalid type!";
    assert ((FriendTy != null)) : "Invalid friend type!";
    return DIDerivedType.get(VMContext, $ushort2uint(Tag.DW_TAG_friend), new StringRef(/*KEEP_STR*/$EMPTY), (DIFile /*P*/ )null, 0, new TypedDINodeRef<DIScope>(DIScope.class, Ty),
        new TypedDINodeRef<DIType>(DIType.class, FriendTy), $int2ulong(0), $int2ulong(0), $int2ulong(0), 0);
  }


  /// Create debugging information entry to establish
  /// inheritance relationship between two types.
  /// \param Ty           Original type.
  /// \param BaseTy       Base type. Ty is inherits from base.
  /// \param BaseOffset   Base offset.
  /// \param Flags        Flags to describe inheritance attribute,
  ///                     e.g. private
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createInheritance">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 252,
   FQN="llvm::DIBuilder::createInheritance", NM="_ZN4llvm9DIBuilder17createInheritanceEPNS_6DITypeES2_yj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder17createInheritanceEPNS_6DITypeES2_yj")
  //</editor-fold>
  public DIDerivedType /*P*/ createInheritance(DIType /*P*/ Ty, DIType /*P*/ BaseTy,
                   long/*uint64_t*/ BaseOffset,
                   /*uint*/int Flags) {
    assert ((Ty != null)) : "Unable to create inheritance";
    return DIDerivedType.get(VMContext, $ushort2uint(Tag.DW_TAG_inheritance), new StringRef(/*KEEP_STR*/$EMPTY), (DIFile /*P*/ )null,
        0, new TypedDINodeRef<DIScope>(DIScope.class, Ty), new TypedDINodeRef<DIType>(DIType.class, BaseTy), $int2ulong(0), $int2ulong(0), BaseOffset, Flags);
  }


  /// Create debugging information entry for a member.
  /// \param Scope        Member scope.
  /// \param Name         Member name.
  /// \param File         File where this member is defined.
  /// \param LineNo       Line number.
  /// \param SizeInBits   Member size.
  /// \param AlignInBits  Member alignment.
  /// \param OffsetInBits Member offset.
  /// \param Flags        Flags to encode member attribute, e.g. private
  /// \param Ty           Parent type.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createMemberType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 260,
   FQN="llvm::DIBuilder::createMemberType", NM="_ZN4llvm9DIBuilder16createMemberTypeEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEjyyyjPNS_6DITypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder16createMemberTypeEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEjyyyjPNS_6DITypeE")
  //</editor-fold>
  public DIDerivedType /*P*/ createMemberType(DIScope /*P*/ Scope, StringRef Name,
                  DIFile /*P*/ File, /*uint*/int LineNumber,
                  long/*uint64_t*/ SizeInBits,
                  long/*uint64_t*/ AlignInBits,
                  long/*uint64_t*/ OffsetInBits,
                  /*uint*/int Flags, DIType /*P*/ Ty) {
    return DIDerivedType.get(VMContext, $ushort2uint(Tag.DW_TAG_member), new StringRef(Name), File,
        LineNumber, new TypedDINodeRef<DIScope>(DIScope.class, DIBuilderStatics.getNonCompileUnitScope(Scope)), new TypedDINodeRef<DIType>(DIType.class, Ty),
        SizeInBits, AlignInBits, OffsetInBits, Flags);
  }


  /// Create debugging information entry for a bit field member.
  /// \param Scope               Member scope.
  /// \param Name                Member name.
  /// \param File                File where this member is defined.
  /// \param LineNo              Line number.
  /// \param SizeInBits          Member size.
  /// \param AlignInBits         Member alignment.
  /// \param OffsetInBits        Member offset.
  /// \param StorageOffsetInBits Member storage offset.
  /// \param Flags               Flags to encode member attribute.
  /// \param Ty                  Parent type.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createBitFieldMemberType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 277,
   FQN="llvm::DIBuilder::createBitFieldMemberType", NM="_ZN4llvm9DIBuilder24createBitFieldMemberTypeEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEjyyyyjPNS_6DITypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder24createBitFieldMemberTypeEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEjyyyyjPNS_6DITypeE")
  //</editor-fold>
  public DIDerivedType /*P*/ createBitFieldMemberType(DIScope /*P*/ Scope, StringRef Name, DIFile /*P*/ File, /*uint*/int LineNumber,
                          long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits,
                          long/*uint64_t*/ StorageOffsetInBits, /*uint*/int Flags, DIType /*P*/ Ty) {
    Flags |= DINode.DIFlags.FlagBitField;
    return DIDerivedType.get(VMContext, $ushort2uint(Tag.DW_TAG_member), new StringRef(Name), File, LineNumber,
        new TypedDINodeRef<DIScope>(DIScope.class, DIBuilderStatics.getNonCompileUnitScope(Scope)), new TypedDINodeRef<DIType>(DIType.class, Ty), SizeInBits, AlignInBits, OffsetInBits,
        Flags, ConstantAsMetadata.get(ConstantInt.get(IntegerType.get(VMContext, 64), StorageOffsetInBits)));
  }


  /// Create debugging information entry for a
  /// C++ static data member.
  /// \param Scope      Member scope.
  /// \param Name       Member name.
  /// \param File       File where this member is declared.
  /// \param LineNo     Line number.
  /// \param Ty         Type of the static member.
  /// \param Flags      Flags to encode member attribute, e.g. private.
  /// \param Val        Const initializer of the member.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createStaticMemberType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 289,
   FQN="llvm::DIBuilder::createStaticMemberType", NM="_ZN4llvm9DIBuilder22createStaticMemberTypeEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEjPNS_6DITypeEjPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder22createStaticMemberTypeEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEjPNS_6DITypeEjPNS_8ConstantE")
  //</editor-fold>
  public DIDerivedType /*P*/ createStaticMemberType(DIScope /*P*/ Scope, StringRef Name,
                        DIFile /*P*/ File,
                        /*uint*/int LineNumber,
                        DIType /*P*/ Ty, /*uint*/int Flags,
                        Constant /*P*/ Val) {
    Flags |= DINode.DIFlags.FlagStaticMember;
    return DIDerivedType.get(VMContext, $ushort2uint(Tag.DW_TAG_member), new StringRef(Name), File,
        LineNumber, new TypedDINodeRef<DIScope>(DIScope.class, DIBuilderStatics.getNonCompileUnitScope(Scope)), new TypedDINodeRef<DIType>(DIType.class, Ty), $int2ulong(0), $int2ulong(0),
        $int2ulong(0), Flags, DIBuilderStatics.getConstantOrNull(Val));
  }


  /// Create debugging information entry for Objective-C
  /// instance variable.
  /// \param Name         Member name.
  /// \param File         File where this member is defined.
  /// \param LineNo       Line number.
  /// \param SizeInBits   Member size.
  /// \param AlignInBits  Member alignment.
  /// \param OffsetInBits Member offset.
  /// \param Flags        Flags to encode member attribute, e.g. private
  /// \param Ty           Parent type.
  /// \param PropertyNode Property associated with this ivar.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createObjCIVar">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 300,
   FQN="llvm::DIBuilder::createObjCIVar", NM="_ZN4llvm9DIBuilder14createObjCIVarENS_9StringRefEPNS_6DIFileEjyyyjPNS_6DITypeEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder14createObjCIVarENS_9StringRefEPNS_6DIFileEjyyyjPNS_6DITypeEPNS_6MDNodeE")
  //</editor-fold>
  public DIDerivedType /*P*/ createObjCIVar(StringRef Name, DIFile /*P*/ File,
                /*uint*/int LineNumber,
                long/*uint64_t*/ SizeInBits,
                long/*uint64_t*/ AlignInBits,
                long/*uint64_t*/ OffsetInBits, /*uint*/int Flags,
                DIType /*P*/ Ty, MDNode /*P*/ PropertyNode) {
    return DIDerivedType.get(VMContext, $ushort2uint(Tag.DW_TAG_member), new StringRef(Name), File,
        LineNumber, new TypedDINodeRef<DIScope>(DIScope.class, DIBuilderStatics.getNonCompileUnitScope(File)), new TypedDINodeRef<DIType>(DIType.class, Ty),
        SizeInBits, AlignInBits, OffsetInBits, Flags,
        PropertyNode);
  }


  /// Create debugging information entry for Objective-C
  /// property.
  /// \param Name         Property name.
  /// \param File         File where this property is defined.
  /// \param LineNumber   Line number.
  /// \param GetterName   Name of the Objective C property getter selector.
  /// \param SetterName   Name of the Objective C property setter selector.
  /// \param PropertyAttributes Objective C property attributes.
  /// \param Ty           Type.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createObjCProperty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 312,
   FQN="llvm::DIBuilder::createObjCProperty", NM="_ZN4llvm9DIBuilder18createObjCPropertyENS_9StringRefEPNS_6DIFileEjS1_S1_jPNS_6DITypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder18createObjCPropertyENS_9StringRefEPNS_6DIFileEjS1_S1_jPNS_6DITypeE")
  //</editor-fold>
  public DIObjCProperty /*P*/ createObjCProperty(StringRef Name, DIFile /*P*/ File, /*uint*/int LineNumber,
                    StringRef GetterName, StringRef SetterName,
                    /*uint*/int PropertyAttributes, DIType /*P*/ Ty) {
    return DIObjCProperty.get(VMContext, new StringRef(Name), File, LineNumber, new StringRef(GetterName),
        new StringRef(SetterName), PropertyAttributes, new TypedDINodeRef<DIType>(DIType.class, Ty));
  }


  /// Create debugging information entry for a class.
  /// \param Scope        Scope in which this class is defined.
  /// \param Name         class name.
  /// \param File         File where this member is defined.
  /// \param LineNumber   Line number.
  /// \param SizeInBits   Member size.
  /// \param AlignInBits  Member alignment.
  /// \param OffsetInBits Member offset.
  /// \param Flags        Flags to encode member attribute, e.g. private
  /// \param Elements     class members.
  /// \param VTableHolder Debug info of the base class that contains vtable
  ///                     for this type. This is used in
  ///                     DW_AT_containing_type. See DWARF documentation
  ///                     for more info.
  /// \param TemplateParms Template type parameters.
  /// \param UniqueIdentifier A unique identifier for the class.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createClassType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 359,
   FQN="llvm::DIBuilder::createClassType", NM="_ZN4llvm9DIBuilder15createClassTypeEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEjyyyjPNS_6DITypeENS_24MDTupleTypedArrayWrapperINS_6DINodeEEES7_PNS_6MDNodeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder15createClassTypeEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEjyyyjPNS_6DITypeENS_24MDTupleTypedArrayWrapperINS_6DINodeEEES7_PNS_6MDNodeES3_")
  //</editor-fold>
  public DICompositeType /*P*/ createClassType(DIScope /*P*/ Context, StringRef Name, DIFile /*P*/ File, /*uint*/int LineNumber,
                 long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits,
                 /*uint*/int Flags, DIType /*P*/ DerivedFrom, MDTupleTypedArrayWrapper<DINode> Elements) {
    return createClassType(Context, Name, File, LineNumber,
                 SizeInBits, AlignInBits, OffsetInBits,
                 Flags, DerivedFrom, Elements,
                 (DIType /*P*/ )null, (MDNode /*P*/ )null, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DICompositeType /*P*/ createClassType(DIScope /*P*/ Context, StringRef Name, DIFile /*P*/ File, /*uint*/int LineNumber,
                 long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits,
                 /*uint*/int Flags, DIType /*P*/ DerivedFrom, MDTupleTypedArrayWrapper<DINode> Elements,
                 DIType /*P*/ VTableHolder/*= null*/) {
    return createClassType(Context, Name, File, LineNumber,
                 SizeInBits, AlignInBits, OffsetInBits,
                 Flags, DerivedFrom, Elements,
                 VTableHolder, (MDNode /*P*/ )null, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DICompositeType /*P*/ createClassType(DIScope /*P*/ Context, StringRef Name, DIFile /*P*/ File, /*uint*/int LineNumber,
                 long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits,
                 /*uint*/int Flags, DIType /*P*/ DerivedFrom, MDTupleTypedArrayWrapper<DINode> Elements,
                 DIType /*P*/ VTableHolder/*= null*/, MDNode /*P*/ TemplateParams/*= null*/) {
    return createClassType(Context, Name, File, LineNumber,
                 SizeInBits, AlignInBits, OffsetInBits,
                 Flags, DerivedFrom, Elements,
                 VTableHolder, TemplateParams, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DICompositeType /*P*/ createClassType(DIScope /*P*/ Context, StringRef Name, DIFile /*P*/ File, /*uint*/int LineNumber,
                 long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits,
                 /*uint*/int Flags, DIType /*P*/ DerivedFrom, MDTupleTypedArrayWrapper<DINode> Elements,
                 DIType /*P*/ VTableHolder/*= null*/, MDNode /*P*/ TemplateParams/*= null*/, StringRef UniqueIdentifier/*= ""*/) {
    assert ((!(Context != null) || isa_DIScope(Context))) : "createClassType should be called with a valid Context";

    DICompositeType /*P*/ R = DICompositeType.get(VMContext, $ushort2uint(Tag.DW_TAG_structure_type), new StringRef(Name), File, LineNumber,
        new TypedDINodeRef<DIScope>(DIScope.class, DIBuilderStatics.getNonCompileUnitScope(Context)), new TypedDINodeRef<DIType>(DIType.class, DerivedFrom), SizeInBits, AlignInBits,
        OffsetInBits, Flags, new MDTupleTypedArrayWrapper<DINode>(Elements), 0, new TypedDINodeRef<DIType>(DIType.class, VTableHolder),
        new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, cast_or_null_MDTuple(TemplateParams)), new StringRef(UniqueIdentifier));
    trackIfUnresolved(R);
    return R;
  }


  /// Create debugging information entry for a struct.
  /// \param Scope        Scope in which this struct is defined.
  /// \param Name         Struct name.
  /// \param File         File where this member is defined.
  /// \param LineNumber   Line number.
  /// \param SizeInBits   Member size.
  /// \param AlignInBits  Member alignment.
  /// \param Flags        Flags to encode member attribute, e.g. private
  /// \param Elements     Struct elements.
  /// \param RunTimeLang  Optional parameter, Objective-C runtime version.
  /// \param UniqueIdentifier A unique identifier for the struct.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createStructType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 376,
   FQN="llvm::DIBuilder::createStructType", NM="_ZN4llvm9DIBuilder16createStructTypeEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEjyyjPNS_6DITypeENS_24MDTupleTypedArrayWrapperINS_6DINodeEEEjS7_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder16createStructTypeEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEjyyjPNS_6DITypeENS_24MDTupleTypedArrayWrapperINS_6DINodeEEEjS7_S3_")
  //</editor-fold>
  public DICompositeType /*P*/ createStructType(DIScope /*P*/ Context, StringRef Name, DIFile /*P*/ File, /*uint*/int LineNumber,
                  long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, /*uint*/int Flags,
                  DIType /*P*/ DerivedFrom, MDTupleTypedArrayWrapper<DINode> Elements) {
    return createStructType(Context, Name, File, LineNumber,
                  SizeInBits, AlignInBits, Flags,
                  DerivedFrom, Elements, 0,
                  (DIType /*P*/ )null, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DICompositeType /*P*/ createStructType(DIScope /*P*/ Context, StringRef Name, DIFile /*P*/ File, /*uint*/int LineNumber,
                  long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, /*uint*/int Flags,
                  DIType /*P*/ DerivedFrom, MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RunTimeLang/*= 0*/) {
    return createStructType(Context, Name, File, LineNumber,
                  SizeInBits, AlignInBits, Flags,
                  DerivedFrom, Elements, RunTimeLang,
                  (DIType /*P*/ )null, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DICompositeType /*P*/ createStructType(DIScope /*P*/ Context, StringRef Name, DIFile /*P*/ File, /*uint*/int LineNumber,
                  long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, /*uint*/int Flags,
                  DIType /*P*/ DerivedFrom, MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RunTimeLang/*= 0*/,
                  DIType /*P*/ VTableHolder/*= null*/) {
    return createStructType(Context, Name, File, LineNumber,
                  SizeInBits, AlignInBits, Flags,
                  DerivedFrom, Elements, RunTimeLang,
                  VTableHolder, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DICompositeType /*P*/ createStructType(DIScope /*P*/ Context, StringRef Name, DIFile /*P*/ File, /*uint*/int LineNumber,
                  long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, /*uint*/int Flags,
                  DIType /*P*/ DerivedFrom, MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RunTimeLang/*= 0*/,
                  DIType /*P*/ VTableHolder/*= null*/, StringRef UniqueIdentifier/*= ""*/) {
    DICompositeType /*P*/ R = DICompositeType.get(VMContext, $ushort2uint(Tag.DW_TAG_structure_type), new StringRef(Name), File, LineNumber,
        new TypedDINodeRef<DIScope>(DIScope.class, DIBuilderStatics.getNonCompileUnitScope(Context)), new TypedDINodeRef<DIType>(DIType.class, DerivedFrom), SizeInBits, AlignInBits, $int2ulong(0),
        Flags, new MDTupleTypedArrayWrapper<DINode>(Elements), RunTimeLang, new TypedDINodeRef<DIType>(DIType.class, VTableHolder), new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), new StringRef(UniqueIdentifier));
    trackIfUnresolved(R);
    return R;
  }


  /// Create debugging information entry for an union.
  /// \param Scope        Scope in which this union is defined.
  /// \param Name         Union name.
  /// \param File         File where this member is defined.
  /// \param LineNumber   Line number.
  /// \param SizeInBits   Member size.
  /// \param AlignInBits  Member alignment.
  /// \param Flags        Flags to encode member attribute, e.g. private
  /// \param Elements     Union elements.
  /// \param RunTimeLang  Optional parameter, Objective-C runtime version.
  /// \param UniqueIdentifier A unique identifier for the union.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createUnionType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 389,
   FQN="llvm::DIBuilder::createUnionType", NM="_ZN4llvm9DIBuilder15createUnionTypeEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEjyyjNS_24MDTupleTypedArrayWrapperINS_6DINodeEEEjS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder15createUnionTypeEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEjyyjNS_24MDTupleTypedArrayWrapperINS_6DINodeEEEjS3_")
  //</editor-fold>
  public DICompositeType /*P*/ createUnionType(DIScope /*P*/ Scope, StringRef Name, DIFile /*P*/ File, /*uint*/int LineNumber,
                 long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, /*uint*/int Flags,
                 MDTupleTypedArrayWrapper<DINode> Elements) {
    return createUnionType(Scope, Name, File, LineNumber,
                 SizeInBits, AlignInBits, Flags,
                 Elements, 0, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DICompositeType /*P*/ createUnionType(DIScope /*P*/ Scope, StringRef Name, DIFile /*P*/ File, /*uint*/int LineNumber,
                 long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, /*uint*/int Flags,
                 MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RunTimeLang/*= 0*/) {
    return createUnionType(Scope, Name, File, LineNumber,
                 SizeInBits, AlignInBits, Flags,
                 Elements, RunTimeLang, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DICompositeType /*P*/ createUnionType(DIScope /*P*/ Scope, StringRef Name, DIFile /*P*/ File, /*uint*/int LineNumber,
                 long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, /*uint*/int Flags,
                 MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RunTimeLang/*= 0*/, StringRef UniqueIdentifier/*= ""*/) {
    DICompositeType /*P*/ R = DICompositeType.get(VMContext, $ushort2uint(Tag.DW_TAG_union_type), new StringRef(Name), File, LineNumber,
        new TypedDINodeRef<DIScope>(DIScope.class, DIBuilderStatics.getNonCompileUnitScope(Scope)), new TypedDINodeRef<DIType>(DIType.class, JD$NullPtr.INSTANCE, null), SizeInBits, AlignInBits, $int2ulong(0), Flags,
        new MDTupleTypedArrayWrapper<DINode>(Elements), RunTimeLang, new TypedDINodeRef<DIType>(DIType.class, JD$NullPtr.INSTANCE, null), new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), new StringRef(UniqueIdentifier));
    trackIfUnresolved(R);
    return R;
  }


  /// Create debugging information for template
  /// type parameter.
  /// \param Scope        Scope in which this type is defined.
  /// \param Name         Type parameter name.
  /// \param Ty           Parameter type.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createTemplateTypeParameter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 320,
   FQN="llvm::DIBuilder::createTemplateTypeParameter", NM="_ZN4llvm9DIBuilder27createTemplateTypeParameterEPNS_7DIScopeENS_9StringRefEPNS_6DITypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder27createTemplateTypeParameterEPNS_7DIScopeENS_9StringRefEPNS_6DITypeE")
  //</editor-fold>
  public DITemplateTypeParameter /*P*/ createTemplateTypeParameter(DIScope /*P*/ Context, StringRef Name,
                             DIType /*P*/ Ty) {
    assert ((!(Context != null) || isa_DICompileUnit(Context))) : "Expected compile unit";
    return DITemplateTypeParameter.get(VMContext, new StringRef(Name), new TypedDINodeRef<DIType>(DIType.class, Ty));
  }


  /// Create debugging information for template
  /// value parameter.
  /// \param Scope        Scope in which this type is defined.
  /// \param Name         Value parameter name.
  /// \param Ty           Parameter type.
  /// \param Val          Constant parameter value.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createTemplateValueParameter">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 335,
   FQN="llvm::DIBuilder::createTemplateValueParameter", NM="_ZN4llvm9DIBuilder28createTemplateValueParameterEPNS_7DIScopeENS_9StringRefEPNS_6DITypeEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder28createTemplateValueParameterEPNS_7DIScopeENS_9StringRefEPNS_6DITypeEPNS_8ConstantE")
  //</editor-fold>
  public DITemplateValueParameter /*P*/ createTemplateValueParameter(DIScope /*P*/ Context, StringRef Name,
                              DIType /*P*/ Ty, Constant /*P*/ Val) {
    return DIBuilderStatics.createTemplateValueParameterHelper(VMContext, $ushort2uint(Tag.DW_TAG_template_value_parameter), Context, new StringRef(Name), Ty,
        DIBuilderStatics.getConstantOrNull(Val));
  }


  /// Create debugging information for a template template parameter.
  /// \param Scope        Scope in which this type is defined.
  /// \param Name         Value parameter name.
  /// \param Ty           Parameter type.
  /// \param Val          The fully qualified name of the template.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createTemplateTemplateParameter">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 343,
   FQN="llvm::DIBuilder::createTemplateTemplateParameter", NM="_ZN4llvm9DIBuilder31createTemplateTemplateParameterEPNS_7DIScopeENS_9StringRefEPNS_6DITypeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder31createTemplateTemplateParameterEPNS_7DIScopeENS_9StringRefEPNS_6DITypeES3_")
  //</editor-fold>
  public DITemplateValueParameter /*P*/ createTemplateTemplateParameter(DIScope /*P*/ Context, StringRef Name,
                                 DIType /*P*/ Ty, StringRef Val) {
    return DIBuilderStatics.createTemplateValueParameterHelper(VMContext, $ushort2uint(Tag.DW_TAG_GNU_template_template_param), Context, new StringRef(Name), Ty,
        MDString.get(VMContext, new StringRef(Val)));
  }


  /// Create debugging information for a template parameter pack.
  /// \param Scope        Scope in which this type is defined.
  /// \param Name         Value parameter name.
  /// \param Ty           Parameter type.
  /// \param Val          An array of types in the pack.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createTemplateParameterPack">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 351,
   FQN="llvm::DIBuilder::createTemplateParameterPack", NM="_ZN4llvm9DIBuilder27createTemplateParameterPackEPNS_7DIScopeENS_9StringRefEPNS_6DITypeENS_24MDTupleTypedArrayWrapperINS_6DINodeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder27createTemplateParameterPackEPNS_7DIScopeENS_9StringRefEPNS_6DITypeENS_24MDTupleTypedArrayWrapperINS_6DINodeEEE")
  //</editor-fold>
  public DITemplateValueParameter /*P*/ createTemplateParameterPack(DIScope /*P*/ Context, StringRef Name,
                             DIType /*P*/ Ty, MDTupleTypedArrayWrapper<DINode> Val) {
    return DIBuilderStatics.createTemplateValueParameterHelper(VMContext, $ushort2uint(Tag.DW_TAG_GNU_template_parameter_pack), Context, new StringRef(Name), Ty,
        Val.get());
  }


  /// Create debugging information entry for an array.
  /// \param Size         Array size.
  /// \param AlignInBits  Alignment.
  /// \param Ty           Element type.
  /// \param Subscripts   Subscripts.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createArrayType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 427,
   FQN="llvm::DIBuilder::createArrayType", NM="_ZN4llvm9DIBuilder15createArrayTypeEyyPNS_6DITypeENS_24MDTupleTypedArrayWrapperINS_6DINodeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder15createArrayTypeEyyPNS_6DITypeENS_24MDTupleTypedArrayWrapperINS_6DINodeEEE")
  //</editor-fold>
  public DICompositeType /*P*/ createArrayType(long/*uint64_t*/ Size, long/*uint64_t*/ AlignInBits,
                 DIType /*P*/ Ty,
                 MDTupleTypedArrayWrapper<DINode> Subscripts) {
    DICompositeType /*P*/ R = DICompositeType.get(VMContext, $ushort2uint(Tag.DW_TAG_array_type), new StringRef(/*KEEP_STR*/$EMPTY),
        (DIFile /*P*/ )null, 0, new TypedDINodeRef<DIScope>(DIScope.class, JD$NullPtr.INSTANCE, null), new TypedDINodeRef<DIType>(DIType.class, Ty), Size, AlignInBits, $int2ulong(0),
        0, new MDTupleTypedArrayWrapper<DINode>(Subscripts), 0, new TypedDINodeRef<DIType>(DIType.class, JD$NullPtr.INSTANCE, null));
    trackIfUnresolved(R);
    return R;
  }


  /// Create debugging information entry for a vector type.
  /// \param Size         Array size.
  /// \param AlignInBits  Alignment.
  /// \param Ty           Element type.
  /// \param Subscripts   Subscripts.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createVectorType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 437,
   FQN="llvm::DIBuilder::createVectorType", NM="_ZN4llvm9DIBuilder16createVectorTypeEyyPNS_6DITypeENS_24MDTupleTypedArrayWrapperINS_6DINodeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder16createVectorTypeEyyPNS_6DITypeENS_24MDTupleTypedArrayWrapperINS_6DINodeEEE")
  //</editor-fold>
  public DICompositeType /*P*/ createVectorType(long/*uint64_t*/ Size,
                  long/*uint64_t*/ AlignInBits, DIType /*P*/ Ty,
                  MDTupleTypedArrayWrapper<DINode> Subscripts) {
    DICompositeType /*P*/ R = DICompositeType.get(VMContext, $ushort2uint(Tag.DW_TAG_array_type), new StringRef(/*KEEP_STR*/$EMPTY),
        (DIFile /*P*/ )null, 0, new TypedDINodeRef<DIScope>(DIScope.class, JD$NullPtr.INSTANCE, null), new TypedDINodeRef<DIType>(DIType.class, Ty), Size, AlignInBits, $int2ulong(0),
        DINode.DIFlags.FlagVector, new MDTupleTypedArrayWrapper<DINode>(Subscripts), 0, new TypedDINodeRef<DIType>(DIType.class, JD$NullPtr.INSTANCE, null));
    trackIfUnresolved(R);
    return R;
  }


  /// Create debugging information entry for an
  /// enumeration.
  /// \param Scope          Scope in which this enumeration is defined.
  /// \param Name           Union name.
  /// \param File           File where this member is defined.
  /// \param LineNumber     Line number.
  /// \param SizeInBits     Member size.
  /// \param AlignInBits    Member alignment.
  /// \param Elements       Enumeration elements.
  /// \param UnderlyingType Underlying type of a C++11/ObjC fixed enum.
  /// \param UniqueIdentifier A unique identifier for the enum.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createEnumerationType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 414,
   FQN="llvm::DIBuilder::createEnumerationType", NM="_ZN4llvm9DIBuilder21createEnumerationTypeEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEjyyNS_24MDTupleTypedArrayWrapperINS_6DINodeEEEPNS_6DITypeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder21createEnumerationTypeEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEjyyNS_24MDTupleTypedArrayWrapperINS_6DINodeEEEPNS_6DITypeES3_")
  //</editor-fold>
  public DICompositeType /*P*/ createEnumerationType(DIScope /*P*/ Scope, StringRef Name, DIFile /*P*/ File, /*uint*/int LineNumber,
                       long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, MDTupleTypedArrayWrapper<DINode> Elements,
                       DIType /*P*/ UnderlyingType) {
    return createEnumerationType(Scope, Name, File, LineNumber,
                       SizeInBits, AlignInBits, Elements,
                       UnderlyingType, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DICompositeType /*P*/ createEnumerationType(DIScope /*P*/ Scope, StringRef Name, DIFile /*P*/ File, /*uint*/int LineNumber,
                       long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, MDTupleTypedArrayWrapper<DINode> Elements,
                       DIType /*P*/ UnderlyingType, StringRef UniqueIdentifier/*= ""*/) {
    DICompositeType /*P*/ CTy = DICompositeType.get(VMContext, $ushort2uint(Tag.DW_TAG_enumeration_type), new StringRef(Name), File, LineNumber,
        new TypedDINodeRef<DIScope>(DIScope.class, DIBuilderStatics.getNonCompileUnitScope(Scope)), new TypedDINodeRef<DIType>(DIType.class, UnderlyingType), SizeInBits, AlignInBits, $int2ulong(0),
        0, new MDTupleTypedArrayWrapper<DINode>(Elements), 0, new TypedDINodeRef<DIType>(DIType.class, JD$NullPtr.INSTANCE, null), new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), new StringRef(UniqueIdentifier));
    AllEnumTypes.push_back(CTy);
    trackIfUnresolved(CTy);
    return CTy;
  }


  /// Create subroutine type.
  /// \param ParameterTypes  An array of subroutine parameter types. This
  ///                        includes return type at 0th index.
  /// \param Flags           E.g.: LValueReference.
  ///                        These flags are used to emit dwarf attributes.
  /// \param CC              Calling convention, e.g. dwarf::DW_CC_normal
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createSubroutineType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 401,
   FQN="llvm::DIBuilder::createSubroutineType", NM="_ZN4llvm9DIBuilder20createSubroutineTypeENS_14DITypeRefArrayEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder20createSubroutineTypeENS_14DITypeRefArrayEjj")
  //</editor-fold>
  public DISubroutineType /*P*/ createSubroutineType(DITypeRefArray ParameterTypes) {
    return createSubroutineType(ParameterTypes,
                      0, 0);
  }
  public DISubroutineType /*P*/ createSubroutineType(DITypeRefArray ParameterTypes,
                      /*uint*/int Flags/*= 0*/) {
    return createSubroutineType(ParameterTypes,
                      Flags, 0);
  }
  public DISubroutineType /*P*/ createSubroutineType(DITypeRefArray ParameterTypes,
                      /*uint*/int Flags/*= 0*/, /*uint*/int CC/*= 0*/) {
    return DISubroutineType.get(VMContext, Flags, $uint2uchar(CC), new DITypeRefArray(ParameterTypes));
  }


  /// Create an external type reference.
  /// \param Tag              Dwarf TAG.
  /// \param File             File in which the type is defined.
  /// \param UniqueIdentifier A unique identifier for the type.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createExternalTypeRef">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 406,
   FQN="llvm::DIBuilder::createExternalTypeRef", NM="_ZN4llvm9DIBuilder21createExternalTypeRefEjPNS_6DIFileENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder21createExternalTypeRefEjPNS_6DIFileENS_9StringRefE")
  //</editor-fold>
  public DICompositeType /*P*/ createExternalTypeRef(/*uint*/int Tag, DIFile /*P*/ File,
                       StringRef UniqueIdentifier) {
    assert (!UniqueIdentifier.empty()) : "external type ref without uid";
    return DICompositeType.get(VMContext, Tag, new StringRef(/*KEEP_STR*/$EMPTY), (DIFile /*P*/ )null, 0, new TypedDINodeRef<DIScope>(DIScope.class, JD$NullPtr.INSTANCE, null), new TypedDINodeRef<DIType>(DIType.class, JD$NullPtr.INSTANCE, null),
        $int2ulong(0), $int2ulong(0), $int2ulong(0), DINode.DIFlags.FlagExternalTypeRef, new MDTupleTypedArrayWrapper<DINode>(DINode.class, (/*const*/ MDTuple /*P*/ )null), 0,
        new TypedDINodeRef<DIType>(DIType.class, JD$NullPtr.INSTANCE, null), new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), new StringRef(UniqueIdentifier));
  }


  /// Create a new DIType* with "artificial" flag set.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createArtificialType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 454,
   FQN="llvm::DIBuilder::createArtificialType", NM="_ZN4llvm9DIBuilder20createArtificialTypeEPNS_6DITypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder20createArtificialTypeEPNS_6DITypeE")
  //</editor-fold>
  public DIType /*P*/ createArtificialType(DIType /*P*/ Ty) {
    // FIXME: Restrict this to the nodes where it's valid.
    if (Ty.isArtificial()) {
      return Ty;
    }
    return DIBuilderStatics.createTypeWithFlags(VMContext, Ty, DINode.DIFlags.FlagArtificial);
  }


  /// Create a new DIType* with the "object pointer"
  /// flag set.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createObjectPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 461,
   FQN="llvm::DIBuilder::createObjectPointerType", NM="_ZN4llvm9DIBuilder23createObjectPointerTypeEPNS_6DITypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder23createObjectPointerTypeEPNS_6DITypeE")
  //</editor-fold>
  public DIType /*P*/ createObjectPointerType(DIType /*P*/ Ty) {
    // FIXME: Restrict this to the nodes where it's valid.
    if (Ty.isObjectPointer()) {
      return Ty;
    }
    /*uint*/int Flags = DINode.DIFlags.FlagObjectPointer | DINode.DIFlags.FlagArtificial;
    return DIBuilderStatics.createTypeWithFlags(VMContext, Ty, Flags);
  }


  /// Create a permanent forward-declared type.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createForwardDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 479,
   FQN="llvm::DIBuilder::createForwardDecl", NM="_ZN4llvm9DIBuilder17createForwardDeclEjNS_9StringRefEPNS_7DIScopeEPNS_6DIFileEjjyyS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder17createForwardDeclEjNS_9StringRefEPNS_7DIScopeEPNS_6DIFileEjjyyS1_")
  //</editor-fold>
  public DICompositeType /*P*/ createForwardDecl(/*uint*/int Tag, StringRef Name, DIScope /*P*/ Scope,
                   DIFile /*P*/ F, /*uint*/int Line) {
    return createForwardDecl(Tag, Name, Scope,
                   F, Line, 0,
                   $int2ulong(0), $int2ulong(0),
                   new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DICompositeType /*P*/ createForwardDecl(/*uint*/int Tag, StringRef Name, DIScope /*P*/ Scope,
                   DIFile /*P*/ F, /*uint*/int Line, /*uint*/int RuntimeLang/*= 0*/) {
    return createForwardDecl(Tag, Name, Scope,
                   F, Line, RuntimeLang,
                   $int2ulong(0), $int2ulong(0),
                   new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DICompositeType /*P*/ createForwardDecl(/*uint*/int Tag, StringRef Name, DIScope /*P*/ Scope,
                   DIFile /*P*/ F, /*uint*/int Line, /*uint*/int RuntimeLang/*= 0*/,
                   long/*uint64_t*/ SizeInBits/*= 0*/) {
    return createForwardDecl(Tag, Name, Scope,
                   F, Line, RuntimeLang,
                   SizeInBits, $int2ulong(0),
                   new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DICompositeType /*P*/ createForwardDecl(/*uint*/int Tag, StringRef Name, DIScope /*P*/ Scope,
                   DIFile /*P*/ F, /*uint*/int Line, /*uint*/int RuntimeLang/*= 0*/,
                   long/*uint64_t*/ SizeInBits/*= 0*/, long/*uint64_t*/ AlignInBits/*= 0*/) {
    return createForwardDecl(Tag, Name, Scope,
                   F, Line, RuntimeLang,
                   SizeInBits, AlignInBits,
                   new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DICompositeType /*P*/ createForwardDecl(/*uint*/int Tag, StringRef Name, DIScope /*P*/ Scope,
                   DIFile /*P*/ F, /*uint*/int Line, /*uint*/int RuntimeLang/*= 0*/,
                   long/*uint64_t*/ SizeInBits/*= 0*/, long/*uint64_t*/ AlignInBits/*= 0*/,
                   StringRef UniqueIdentifier/*= ""*/) {
    // FIXME: Define in terms of createReplaceableForwardDecl() by calling
    // replaceWithUniqued().
    DICompositeType /*P*/ RetTy = DICompositeType.get(VMContext, Tag, new StringRef(Name), F, Line, new TypedDINodeRef<DIScope>(DIScope.class, DIBuilderStatics.getNonCompileUnitScope(Scope)), new TypedDINodeRef<DIType>(DIType.class, JD$NullPtr.INSTANCE, null),
        SizeInBits, AlignInBits, $int2ulong(0), DINode.DIFlags.FlagFwdDecl, new MDTupleTypedArrayWrapper<DINode>(DINode.class, (/*const*/ MDTuple /*P*/ )null), RuntimeLang,
        new TypedDINodeRef<DIType>(DIType.class, JD$NullPtr.INSTANCE, null), new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), new StringRef(UniqueIdentifier));
    trackIfUnresolved(RetTy);
    return RetTy;
  }


  /// Create a temporary forward-declared type.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createReplaceableCompositeType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 494,
   FQN="llvm::DIBuilder::createReplaceableCompositeType", NM="_ZN4llvm9DIBuilder30createReplaceableCompositeTypeEjNS_9StringRefEPNS_7DIScopeEPNS_6DIFileEjjyyjS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder30createReplaceableCompositeTypeEjNS_9StringRefEPNS_7DIScopeEPNS_6DIFileEjjyyjS1_")
  //</editor-fold>
  public DICompositeType /*P*/ createReplaceableCompositeType(/*uint*/int Tag, StringRef Name, DIScope /*P*/ Scope, DIFile /*P*/ F, /*uint*/int Line) {
    return createReplaceableCompositeType(Tag, Name, Scope, F, Line,
                                0, $int2ulong(0), $int2ulong(0),
                                DINode.DIFlags.FlagFwdDecl, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DICompositeType /*P*/ createReplaceableCompositeType(/*uint*/int Tag, StringRef Name, DIScope /*P*/ Scope, DIFile /*P*/ F, /*uint*/int Line,
                                /*uint*/int RuntimeLang/*= 0*/) {
    return createReplaceableCompositeType(Tag, Name, Scope, F, Line,
                                RuntimeLang, $int2ulong(0), $int2ulong(0),
                                DINode.DIFlags.FlagFwdDecl, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DICompositeType /*P*/ createReplaceableCompositeType(/*uint*/int Tag, StringRef Name, DIScope /*P*/ Scope, DIFile /*P*/ F, /*uint*/int Line,
                                /*uint*/int RuntimeLang/*= 0*/, long/*uint64_t*/ SizeInBits/*= 0*/) {
    return createReplaceableCompositeType(Tag, Name, Scope, F, Line,
                                RuntimeLang, SizeInBits, $int2ulong(0),
                                DINode.DIFlags.FlagFwdDecl, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DICompositeType /*P*/ createReplaceableCompositeType(/*uint*/int Tag, StringRef Name, DIScope /*P*/ Scope, DIFile /*P*/ F, /*uint*/int Line,
                                /*uint*/int RuntimeLang/*= 0*/, long/*uint64_t*/ SizeInBits/*= 0*/, long/*uint64_t*/ AlignInBits/*= 0*/) {
    return createReplaceableCompositeType(Tag, Name, Scope, F, Line,
                                RuntimeLang, SizeInBits, AlignInBits,
                                DINode.DIFlags.FlagFwdDecl, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DICompositeType /*P*/ createReplaceableCompositeType(/*uint*/int Tag, StringRef Name, DIScope /*P*/ Scope, DIFile /*P*/ F, /*uint*/int Line,
                                /*uint*/int RuntimeLang/*= 0*/, long/*uint64_t*/ SizeInBits/*= 0*/, long/*uint64_t*/ AlignInBits/*= 0*/,
                                /*uint*/int Flags/*= DINode::FlagFwdDecl*/) {
    return createReplaceableCompositeType(Tag, Name, Scope, F, Line,
                                RuntimeLang, SizeInBits, AlignInBits,
                                Flags, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DICompositeType /*P*/ createReplaceableCompositeType(/*uint*/int Tag, StringRef Name, DIScope /*P*/ Scope, DIFile /*P*/ F, /*uint*/int Line,
                                /*uint*/int RuntimeLang/*= 0*/, long/*uint64_t*/ SizeInBits/*= 0*/, long/*uint64_t*/ AlignInBits/*= 0*/,
                                /*uint*/int Flags/*= DINode::FlagFwdDecl*/, StringRef UniqueIdentifier/*= ""*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      DICompositeType /*P*/ RetTy = $c$.clean($c$.track(DICompositeType.getTemporary(VMContext, Tag, new StringRef(Name), F, Line, new TypedDINodeRef<DIScope>(DIScope.class, DIBuilderStatics.getNonCompileUnitScope(Scope)), new TypedDINodeRef<DIType>(DIType.class, JD$NullPtr.INSTANCE, null),
          SizeInBits, AlignInBits, $int2ulong(0), Flags, new MDTupleTypedArrayWrapper<DINode>(DINode.class, (/*const*/ MDTuple /*P*/ )null), RuntimeLang, new TypedDINodeRef<DIType>(DIType.class, JD$NullPtr.INSTANCE, null),
          new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), new StringRef(UniqueIdentifier))).
          release());
      trackIfUnresolved(RetTy);
      return RetTy;
    } finally {
      $c$.$destroy();
    }
  }


  /// Retain DIScope* in a module even if it is not referenced
  /// through debug info anchors.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::retainType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 469,
   FQN="llvm::DIBuilder::retainType", NM="_ZN4llvm9DIBuilder10retainTypeEPNS_7DIScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder10retainTypeEPNS_7DIScopeE")
  //</editor-fold>
  public void retainType(DIScope /*P*/ T) {
    assert ((T != null)) : "Expected non-null type";
    assert ((isa_DIType(T) || (isa_DISubprogram(T) && cast_DISubprogram(T).isDefinition() == false))) : "Expected type or subprogram declaration";
    AllRetainTypes.emplace_back(new TypedTrackingMDRef<MDNode>(T));
  }


  /// Create unspecified parameter type
  /// for a subroutine type.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createUnspecifiedParameter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 477,
   FQN="llvm::DIBuilder::createUnspecifiedParameter", NM="_ZN4llvm9DIBuilder26createUnspecifiedParameterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder26createUnspecifiedParameterEv")
  //</editor-fold>
  public DIBasicType /*P*/ createUnspecifiedParameter() {
    return null;
  }


  /// Get a DINodeArray, create one if required.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::getOrCreateArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 508,
   FQN="llvm::DIBuilder::getOrCreateArray", NM="_ZN4llvm9DIBuilder16getOrCreateArrayENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder16getOrCreateArrayENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  public MDTupleTypedArrayWrapper<DINode> getOrCreateArray(ArrayRef<Metadata /*P*/ > Elements) {
    return new MDTupleTypedArrayWrapper<DINode>(DINode.class, MDTuple.get(VMContext, new ArrayRef<Metadata /*P*/ >(Elements)));
  }


  /// Get a DITypeRefArray, create one if required.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::getOrCreateTypeArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 512,
   FQN="llvm::DIBuilder::getOrCreateTypeArray", NM="_ZN4llvm9DIBuilder20getOrCreateTypeArrayENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder20getOrCreateTypeArrayENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  public DITypeRefArray getOrCreateTypeArray(ArrayRef<Metadata /*P*/ > Elements) {
    SmallVector<Metadata /*P*/ > Elts/*J*/= new SmallVector<Metadata /*P*/ >(16, (Metadata /*P*/ )null);
    for (/*uint*/int i = 0, e = Elements.size(); i != e; ++i) {
      if ((Elements.$at(i) != null) && isa_MDNode(Elements.$at(i))) {
        Elts.push_back(cast_DIType(Elements.$at(i)));
      } else {
        Elts.push_back(Elements.$at(i));
      }
    }
    return new DITypeRefArray(MDNode.get(VMContext, new ArrayRef<Metadata /*P*/ >(Elts, true)));
  }


  /// Create a descriptor for a value range.  This
  /// implicitly uniques the values returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::getOrCreateSubrange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 523,
   FQN="llvm::DIBuilder::getOrCreateSubrange", NM="_ZN4llvm9DIBuilder19getOrCreateSubrangeExx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder19getOrCreateSubrangeExx")
  //</editor-fold>
  public DISubrange /*P*/ getOrCreateSubrange(long/*int64_t*/ Lo, long/*int64_t*/ Count) {
    return DISubrange.get(VMContext, Count, Lo);
  }


  /// Create a new descriptor for the specified
  /// variable.
  /// \param Context     Variable scope.
  /// \param Name        Name of the variable.
  /// \param LinkageName Mangled  name of the variable.
  /// \param File        File where this variable is defined.
  /// \param LineNo      Line number.
  /// \param Ty          Variable Type.
  /// \param isLocalToUnit Boolean flag indicate whether this variable is
  ///                      externally visible or not.
  /// \param Val         llvm::Value of the variable.
  /// \param Decl        Reference to the corresponding declaration.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createGlobalVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 536,
   FQN="llvm::DIBuilder::createGlobalVariable", NM="_ZN4llvm9DIBuilder20createGlobalVariableEPNS_7DIScopeENS_9StringRefES3_PNS_6DIFileEjPNS_6DITypeEbPNS_8ConstantEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder20createGlobalVariableEPNS_7DIScopeENS_9StringRefES3_PNS_6DIFileEjPNS_6DITypeEbPNS_8ConstantEPNS_6MDNodeE")
  //</editor-fold>
  public DIGlobalVariable /*P*/ createGlobalVariable(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName, DIFile /*P*/ F,
                      /*uint*/int LineNumber, DIType /*P*/ Ty, boolean isLocalToUnit, Constant /*P*/ Val) {
    return createGlobalVariable(Context, Name, LinkageName, F,
                      LineNumber, Ty, isLocalToUnit, Val,
                      (MDNode /*P*/ )null);
  }
  public DIGlobalVariable /*P*/ createGlobalVariable(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName, DIFile /*P*/ F,
                      /*uint*/int LineNumber, DIType /*P*/ Ty, boolean isLocalToUnit, Constant /*P*/ Val,
                      MDNode /*P*/ Decl/*= null*/) {
    DIBuilderStatics.checkGlobalVariableScope(Context);

    DIGlobalVariable /*P*/ N = DIGlobalVariable.getDistinct(VMContext, cast_or_null_DIScope(Context), new StringRef(Name), new StringRef(LinkageName), F,
        LineNumber, new TypedDINodeRef<DIType>(DIType.class, Ty), isLocalToUnit, true, Val,
        cast_or_null_DIDerivedType(Decl));
    AllGVs.push_back(N);
    return N;
  }


  /// Identical to createGlobalVariable
  /// except that the resulting DbgNode is temporary and meant to be RAUWed.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createTempGlobalVariableFwdDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 550,
   FQN="llvm::DIBuilder::createTempGlobalVariableFwdDecl", NM="_ZN4llvm9DIBuilder31createTempGlobalVariableFwdDeclEPNS_7DIScopeENS_9StringRefES3_PNS_6DIFileEjPNS_6DITypeEbPNS_8ConstantEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder31createTempGlobalVariableFwdDeclEPNS_7DIScopeENS_9StringRefES3_PNS_6DIFileEjPNS_6DITypeEbPNS_8ConstantEPNS_6MDNodeE")
  //</editor-fold>
  public DIGlobalVariable /*P*/ createTempGlobalVariableFwdDecl(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName, DIFile /*P*/ F,
                                 /*uint*/int LineNumber, DIType /*P*/ Ty, boolean isLocalToUnit, Constant /*P*/ Val) {
    return createTempGlobalVariableFwdDecl(Context, Name, LinkageName, F,
                                 LineNumber, Ty, isLocalToUnit, Val,
                                 (MDNode /*P*/ )null);
  }
  public DIGlobalVariable /*P*/ createTempGlobalVariableFwdDecl(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName, DIFile /*P*/ F,
                                 /*uint*/int LineNumber, DIType /*P*/ Ty, boolean isLocalToUnit, Constant /*P*/ Val,
                                 MDNode /*P*/ Decl/*= null*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      DIBuilderStatics.checkGlobalVariableScope(Context);

      return $c$.clean($c$.track(DIGlobalVariable.getTemporary(VMContext, cast_or_null_DIScope(Context), new StringRef(Name), new StringRef(LinkageName), F,
          LineNumber, new TypedDINodeRef<DIType>(DIType.class, Ty), isLocalToUnit, false, Val,
          cast_or_null_DIDerivedType(Decl))).
          release());
    } finally {
      $c$.$destroy();
    }
  }


  /// Create a new descriptor for an auto variable.  This is a local variable
  /// that is not a subprogram parameter.
  ///
  /// \c Scope must be a \a DILocalScope, and thus its scope chain eventually
  /// leads to a \a DISubprogram.
  ///
  /// If \c AlwaysPreserve, this variable will be referenced from its
  /// containing subprogram, and will survive some optimizations.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createAutoVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 588,
   FQN="llvm::DIBuilder::createAutoVariable", NM="_ZN4llvm9DIBuilder18createAutoVariableEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEjPNS_6DITypeEbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder18createAutoVariableEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEjPNS_6DITypeEbj")
  //</editor-fold>
  public DILocalVariable /*P*/ createAutoVariable(DIScope /*P*/ Scope, StringRef Name,
                    DIFile /*P*/ File, /*uint*/int LineNo,
                    DIType /*P*/ Ty) {
    return createAutoVariable(Scope, Name,
                    File, LineNo,
                    Ty, false,
                    0);
  }
  public DILocalVariable /*P*/ createAutoVariable(DIScope /*P*/ Scope, StringRef Name,
                    DIFile /*P*/ File, /*uint*/int LineNo,
                    DIType /*P*/ Ty, boolean AlwaysPreserve/*= false*/) {
    return createAutoVariable(Scope, Name,
                    File, LineNo,
                    Ty, AlwaysPreserve,
                    0);
  }
  public DILocalVariable /*P*/ createAutoVariable(DIScope /*P*/ Scope, StringRef Name,
                    DIFile /*P*/ File, /*uint*/int LineNo,
                    DIType /*P*/ Ty, boolean AlwaysPreserve/*= false*/,
                    /*uint*/int Flags/*= 0*/) {
    return DIBuilderStatics.createLocalVariable(VMContext, PreservedVariables, Scope, new StringRef(Name),
        /* ArgNo */ 0, File, LineNo, Ty, AlwaysPreserve,
        Flags);
  }


  /// Create a new descriptor for a parameter variable.
  ///
  /// \c Scope must be a \a DILocalScope, and thus its scope chain eventually
  /// leads to a \a DISubprogram.
  ///
  /// \c ArgNo is the index (starting from \c 1) of this variable in the
  /// subprogram parameters.  \c ArgNo should not conflict with other
  /// parameters of the same subprogram.
  ///
  /// If \c AlwaysPreserve, this variable will be referenced from its
  /// containing subprogram, and will survive some optimizations.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createParameterVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 597,
   FQN="llvm::DIBuilder::createParameterVariable", NM="_ZN4llvm9DIBuilder23createParameterVariableEPNS_7DIScopeENS_9StringRefEjPNS_6DIFileEjPNS_6DITypeEbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder23createParameterVariableEPNS_7DIScopeENS_9StringRefEjPNS_6DIFileEjPNS_6DITypeEbj")
  //</editor-fold>
  public DILocalVariable /*P*/ createParameterVariable(DIScope /*P*/ Scope, StringRef Name, /*uint*/int ArgNo, DIFile /*P*/ File,
                         /*uint*/int LineNo, DIType /*P*/ Ty) {
    return createParameterVariable(Scope, Name, ArgNo, File,
                         LineNo, Ty, false, 0);
  }
  public DILocalVariable /*P*/ createParameterVariable(DIScope /*P*/ Scope, StringRef Name, /*uint*/int ArgNo, DIFile /*P*/ File,
                         /*uint*/int LineNo, DIType /*P*/ Ty, boolean AlwaysPreserve/*= false*/) {
    return createParameterVariable(Scope, Name, ArgNo, File,
                         LineNo, Ty, AlwaysPreserve, 0);
  }
  public DILocalVariable /*P*/ createParameterVariable(DIScope /*P*/ Scope, StringRef Name, /*uint*/int ArgNo, DIFile /*P*/ File,
                         /*uint*/int LineNo, DIType /*P*/ Ty, boolean AlwaysPreserve/*= false*/, /*uint*/int Flags/*= 0*/) {
    assert ((ArgNo != 0)) : "Expected non-zero argument number for parameter";
    return DIBuilderStatics.createLocalVariable(VMContext, PreservedVariables, Scope, new StringRef(Name), ArgNo,
        File, LineNo, Ty, AlwaysPreserve, Flags);
  }


  /// Create a new descriptor for the specified
  /// variable which has a complex address expression for its address.
  /// \param Addr        An array of complex address operations.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 605,
   FQN="llvm::DIBuilder::createExpression", NM="_ZN4llvm9DIBuilder16createExpressionENS_8ArrayRefIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder16createExpressionENS_8ArrayRefIyEE")
  //</editor-fold>
  public DIExpression /*P*/ createExpression() {
    return createExpression(new ArrayRefULong(None));
  }
  public DIExpression /*P*/ createExpression(ArrayRefULong Addr/*= None*/) {
    return DIExpression.get(VMContext, new ArrayRefULong(Addr));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createExpression">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 609,
   FQN="llvm::DIBuilder::createExpression", NM="_ZN4llvm9DIBuilder16createExpressionENS_8ArrayRefIxEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder16createExpressionENS_8ArrayRefIxEE")
  //</editor-fold>
  public DIExpression /*P*/ createExpression(ArrayRefLong Signed) {
    // TODO: Remove the callers of this signed version and delete.
    SmallVectorULong Addr/*J*/= new SmallVectorULong(JD$T.INSTANCE, 8, transform_long2ulong$ptr(Signed.begin()), transform_long2ulong$ptr(Signed.end()), (long/*uint64_t*/)0);
    return createExpression(new ArrayRefULong(Addr));
  }


  /// Create a descriptor to describe one part
  /// of aggregate variable that is fragmented across multiple Values.
  ///
  /// \param OffsetInBits Offset of the piece in bits.
  /// \param SizeInBits   Size of the piece in bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createBitPieceExpression">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 615,
   FQN="llvm::DIBuilder::createBitPieceExpression", NM="_ZN4llvm9DIBuilder24createBitPieceExpressionEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder24createBitPieceExpressionEjj")
  //</editor-fold>
  public DIExpression /*P*/ createBitPieceExpression(/*uint*/int OffsetInBytes,
                          /*uint*/int SizeInBytes) {
    long/*uint64_t*/ Addr[/*3*/] = new$ulong(3, LocationAtom.DW_OP_bit_piece, OffsetInBytes, SizeInBytes);
    return DIExpression.get(VMContext, new ArrayRefULong(Addr));
  }


  /// Create a new descriptor for the specified subprogram.
  /// See comments in DISubprogram* for descriptions of these fields.
  /// \param Scope         Function scope.
  /// \param Name          Function name.
  /// \param LinkageName   Mangled function name.
  /// \param File          File where this variable is defined.
  /// \param LineNo        Line number.
  /// \param Ty            Function type.
  /// \param isLocalToUnit True if this function is not externally visible.
  /// \param isDefinition  True if this is a function definition.
  /// \param ScopeLine     Set to the beginning of the scope this starts
  /// \param Flags         e.g. is this function prototyped or not.
  ///                      These flags are used to emit dwarf attributes.
  /// \param isOptimized   True if optimization is ON.
  /// \param TParams       Function template parameters.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createFunction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 628,
   FQN="llvm::DIBuilder::createFunction", NM="_ZN4llvm9DIBuilder14createFunctionEPNS_7DIScopeENS_9StringRefES3_PNS_6DIFileEjPNS_16DISubroutineTypeEbbjjbNS_24MDTupleTypedArrayWrapperINS_19DITemplateParameterEEEPNS_12DISubprogramE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder14createFunctionEPNS_7DIScopeENS_9StringRefES3_PNS_6DIFileEjPNS_16DISubroutineTypeEbbjjbNS_24MDTupleTypedArrayWrapperINS_19DITemplateParameterEEEPNS_12DISubprogramE")
  //</editor-fold>
  public DISubprogram /*P*/ createFunction(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName, DIFile /*P*/ File,
                /*uint*/int LineNo, DISubroutineType /*P*/ Ty, boolean isLocalToUnit,
                boolean isDefinition, /*uint*/int ScopeLine) {
    return createFunction(Context, Name, LinkageName, File,
                LineNo, Ty, isLocalToUnit,
                isDefinition, ScopeLine, 0, false,
                new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), (DISubprogram /*P*/ )null);
  }
  public DISubprogram /*P*/ createFunction(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName, DIFile /*P*/ File,
                /*uint*/int LineNo, DISubroutineType /*P*/ Ty, boolean isLocalToUnit,
                boolean isDefinition, /*uint*/int ScopeLine, /*uint*/int Flags/*= 0*/) {
    return createFunction(Context, Name, LinkageName, File,
                LineNo, Ty, isLocalToUnit,
                isDefinition, ScopeLine, Flags, false,
                new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), (DISubprogram /*P*/ )null);
  }
  public DISubprogram /*P*/ createFunction(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName, DIFile /*P*/ File,
                /*uint*/int LineNo, DISubroutineType /*P*/ Ty, boolean isLocalToUnit,
                boolean isDefinition, /*uint*/int ScopeLine, /*uint*/int Flags/*= 0*/, boolean isOptimized/*= false*/) {
    return createFunction(Context, Name, LinkageName, File,
                LineNo, Ty, isLocalToUnit,
                isDefinition, ScopeLine, Flags, isOptimized,
                new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), (DISubprogram /*P*/ )null);
  }
  public DISubprogram /*P*/ createFunction(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName, DIFile /*P*/ File,
                /*uint*/int LineNo, DISubroutineType /*P*/ Ty, boolean isLocalToUnit,
                boolean isDefinition, /*uint*/int ScopeLine, /*uint*/int Flags/*= 0*/, boolean isOptimized/*= false*/,
                MDTupleTypedArrayWrapper<DITemplateParameter> TParams/*= null*/) {
    return createFunction(Context, Name, LinkageName, File,
                LineNo, Ty, isLocalToUnit,
                isDefinition, ScopeLine, Flags, isOptimized,
                TParams, (DISubprogram /*P*/ )null);
  }
  public DISubprogram /*P*/ createFunction(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName, DIFile /*P*/ File,
                /*uint*/int LineNo, DISubroutineType /*P*/ Ty, boolean isLocalToUnit,
                boolean isDefinition, /*uint*/int ScopeLine, /*uint*/int Flags/*= 0*/, boolean isOptimized/*= false*/,
                MDTupleTypedArrayWrapper<DITemplateParameter> TParams/*= null*/, DISubprogram /*P*/ Decl/*= null*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      DISubprogram /*P*/ Node = $c$.clean(DIBuilderStatics.getSubprogram(/* IsDistinct = */ isDefinition, VMContext,
          DIBuilderStatics.getNonCompileUnitScope(Context), Name, LinkageName, File, LineNo, Ty,
          isLocalToUnit, isDefinition, ScopeLine, null, 0, 0, 0, Flags,
          isOptimized, isDefinition ? CUNode : (DICompileUnit /*P*/ )null, TParams, Decl,
          $c$.track(MDTuple.getTemporary(VMContext, new ArrayRef<Metadata /*P*/ >(None, true))).release()));
      if (isDefinition) {
        AllSubprograms.push_back(Node);
      }
      trackIfUnresolved(Node);
      return Node;
    } finally {
      $c$.$destroy();
    }
  }


  /// Identical to createFunction,
  /// except that the resulting DbgNode is meant to be RAUWed.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createTempFunctionFwdDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 646,
   FQN="llvm::DIBuilder::createTempFunctionFwdDecl", NM="_ZN4llvm9DIBuilder25createTempFunctionFwdDeclEPNS_7DIScopeENS_9StringRefES3_PNS_6DIFileEjPNS_16DISubroutineTypeEbbjjbNS_24MDTupleTypedArrayWrapperINS_19DITemplateParameterEEEPNS_12DISubprogramE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder25createTempFunctionFwdDeclEPNS_7DIScopeENS_9StringRefES3_PNS_6DIFileEjPNS_16DISubroutineTypeEbbjjbNS_24MDTupleTypedArrayWrapperINS_19DITemplateParameterEEEPNS_12DISubprogramE")
  //</editor-fold>
  public DISubprogram /*P*/ createTempFunctionFwdDecl(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName, DIFile /*P*/ File,
                           /*uint*/int LineNo, DISubroutineType /*P*/ Ty, boolean isLocalToUnit,
                           boolean isDefinition, /*uint*/int ScopeLine) {
    return createTempFunctionFwdDecl(Context, Name, LinkageName, File,
                           LineNo, Ty, isLocalToUnit,
                           isDefinition, ScopeLine, 0, false,
                           new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), (DISubprogram /*P*/ )null);
  }
  public DISubprogram /*P*/ createTempFunctionFwdDecl(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName, DIFile /*P*/ File,
                           /*uint*/int LineNo, DISubroutineType /*P*/ Ty, boolean isLocalToUnit,
                           boolean isDefinition, /*uint*/int ScopeLine, /*uint*/int Flags/*= 0*/) {
    return createTempFunctionFwdDecl(Context, Name, LinkageName, File,
                           LineNo, Ty, isLocalToUnit,
                           isDefinition, ScopeLine, Flags, false,
                           new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), (DISubprogram /*P*/ )null);
  }
  public DISubprogram /*P*/ createTempFunctionFwdDecl(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName, DIFile /*P*/ File,
                           /*uint*/int LineNo, DISubroutineType /*P*/ Ty, boolean isLocalToUnit,
                           boolean isDefinition, /*uint*/int ScopeLine, /*uint*/int Flags/*= 0*/, boolean isOptimized/*= false*/) {
    return createTempFunctionFwdDecl(Context, Name, LinkageName, File,
                           LineNo, Ty, isLocalToUnit,
                           isDefinition, ScopeLine, Flags, isOptimized,
                           new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), (DISubprogram /*P*/ )null);
  }
  public DISubprogram /*P*/ createTempFunctionFwdDecl(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName, DIFile /*P*/ File,
                           /*uint*/int LineNo, DISubroutineType /*P*/ Ty, boolean isLocalToUnit,
                           boolean isDefinition, /*uint*/int ScopeLine, /*uint*/int Flags/*= 0*/, boolean isOptimized/*= false*/,
                           MDTupleTypedArrayWrapper<DITemplateParameter> TParams/*= null*/) {
    return createTempFunctionFwdDecl(Context, Name, LinkageName, File,
                           LineNo, Ty, isLocalToUnit,
                           isDefinition, ScopeLine, Flags, isOptimized,
                           TParams, (DISubprogram /*P*/ )null);
  }
  public DISubprogram /*P*/ createTempFunctionFwdDecl(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName, DIFile /*P*/ File,
                           /*uint*/int LineNo, DISubroutineType /*P*/ Ty, boolean isLocalToUnit,
                           boolean isDefinition, /*uint*/int ScopeLine, /*uint*/int Flags/*= 0*/, boolean isOptimized/*= false*/,
                           MDTupleTypedArrayWrapper<DITemplateParameter> TParams/*= null*/, DISubprogram /*P*/ Decl/*= null*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($c$.track(DISubprogram.getTemporary(VMContext, new TypedDINodeRef<DIScope>(DIScope.class, DIBuilderStatics.getNonCompileUnitScope(Context)), new StringRef(Name), new StringRef(LinkageName),
          File, LineNo, Ty, isLocalToUnit, isDefinition, ScopeLine, new TypedDINodeRef<DIType>(DIType.class, JD$NullPtr.INSTANCE, null),
          0, 0, 0, Flags, isOptimized, isDefinition ? CUNode : (DICompileUnit /*P*/ )null,
          new MDTupleTypedArrayWrapper<DITemplateParameter>(TParams), Decl, new MDTupleTypedArrayWrapper<DILocalVariable>(DILocalVariable.class, (/*const*/ MDTuple /*P*/ )null))).
          release());
    } finally {
      $c$.$destroy();
    }
  }


  /// Create a new descriptor for the specified C++ method.
  /// See comments in \a DISubprogram* for descriptions of these fields.
  /// \param Scope         Function scope.
  /// \param Name          Function name.
  /// \param LinkageName   Mangled function name.
  /// \param File          File where this variable is defined.
  /// \param LineNo        Line number.
  /// \param Ty            Function type.
  /// \param isLocalToUnit True if this function is not externally visible..
  /// \param isDefinition  True if this is a function definition.
  /// \param Virtuality    Attributes describing virtualness. e.g. pure
  ///                      virtual function.
  /// \param VTableIndex   Index no of this method in virtual table, or -1u if
  ///                      unrepresentable.
  /// \param ThisAdjustment
  ///                      MS ABI-specific adjustment of 'this' that occurs
  ///                      in the prologue.
  /// \param VTableHolder  Type that holds vtable.
  /// \param Flags         e.g. is this function prototyped or not.
  ///                      This flags are used to emit dwarf attributes.
  /// \param isOptimized   True if optimization is ON.
  /// \param TParams       Function template parameters.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 659,
   FQN="llvm::DIBuilder::createMethod", NM="_ZN4llvm9DIBuilder12createMethodEPNS_7DIScopeENS_9StringRefES3_PNS_6DIFileEjPNS_16DISubroutineTypeEbbjjiPNS_6DITypeEjbNS_24MDTupleTypedArrayWrapperINS_19DITemplateParameterEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder12createMethodEPNS_7DIScopeENS_9StringRefES3_PNS_6DIFileEjPNS_16DISubroutineTypeEbbjjiPNS_6DITypeEjbNS_24MDTupleTypedArrayWrapperINS_19DITemplateParameterEEE")
  //</editor-fold>
  public DISubprogram /*P*/ createMethod(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName,
              DIFile /*P*/ F, /*uint*/int LineNo, DISubroutineType /*P*/ Ty,
              boolean isLocalToUnit, boolean isDefinition) {
    return createMethod(Context, Name, LinkageName,
              F, LineNo, Ty,
              isLocalToUnit, isDefinition, 0,
              0, 0,
              (DIType /*P*/ )null, 0, false,
              new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public DISubprogram /*P*/ createMethod(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName,
              DIFile /*P*/ F, /*uint*/int LineNo, DISubroutineType /*P*/ Ty,
              boolean isLocalToUnit, boolean isDefinition, /*uint*/int VK/*= 0*/) {
    return createMethod(Context, Name, LinkageName,
              F, LineNo, Ty,
              isLocalToUnit, isDefinition, VK,
              0, 0,
              (DIType /*P*/ )null, 0, false,
              new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public DISubprogram /*P*/ createMethod(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName,
              DIFile /*P*/ F, /*uint*/int LineNo, DISubroutineType /*P*/ Ty,
              boolean isLocalToUnit, boolean isDefinition, /*uint*/int VK/*= 0*/,
              /*uint*/int VIndex/*= 0*/) {
    return createMethod(Context, Name, LinkageName,
              F, LineNo, Ty,
              isLocalToUnit, isDefinition, VK,
              VIndex, 0,
              (DIType /*P*/ )null, 0, false,
              new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public DISubprogram /*P*/ createMethod(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName,
              DIFile /*P*/ F, /*uint*/int LineNo, DISubroutineType /*P*/ Ty,
              boolean isLocalToUnit, boolean isDefinition, /*uint*/int VK/*= 0*/,
              /*uint*/int VIndex/*= 0*/, int ThisAdjustment/*= 0*/) {
    return createMethod(Context, Name, LinkageName,
              F, LineNo, Ty,
              isLocalToUnit, isDefinition, VK,
              VIndex, ThisAdjustment,
              (DIType /*P*/ )null, 0, false,
              new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public DISubprogram /*P*/ createMethod(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName,
              DIFile /*P*/ F, /*uint*/int LineNo, DISubroutineType /*P*/ Ty,
              boolean isLocalToUnit, boolean isDefinition, /*uint*/int VK/*= 0*/,
              /*uint*/int VIndex/*= 0*/, int ThisAdjustment/*= 0*/,
              DIType /*P*/ VTableHolder/*= null*/) {
    return createMethod(Context, Name, LinkageName,
              F, LineNo, Ty,
              isLocalToUnit, isDefinition, VK,
              VIndex, ThisAdjustment,
              VTableHolder, 0, false,
              new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public DISubprogram /*P*/ createMethod(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName,
              DIFile /*P*/ F, /*uint*/int LineNo, DISubroutineType /*P*/ Ty,
              boolean isLocalToUnit, boolean isDefinition, /*uint*/int VK/*= 0*/,
              /*uint*/int VIndex/*= 0*/, int ThisAdjustment/*= 0*/,
              DIType /*P*/ VTableHolder/*= null*/, /*uint*/int Flags/*= 0*/) {
    return createMethod(Context, Name, LinkageName,
              F, LineNo, Ty,
              isLocalToUnit, isDefinition, VK,
              VIndex, ThisAdjustment,
              VTableHolder, Flags, false,
              new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public DISubprogram /*P*/ createMethod(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName,
              DIFile /*P*/ F, /*uint*/int LineNo, DISubroutineType /*P*/ Ty,
              boolean isLocalToUnit, boolean isDefinition, /*uint*/int VK/*= 0*/,
              /*uint*/int VIndex/*= 0*/, int ThisAdjustment/*= 0*/,
              DIType /*P*/ VTableHolder/*= null*/, /*uint*/int Flags/*= 0*/, boolean isOptimized/*= false*/) {
    return createMethod(Context, Name, LinkageName,
              F, LineNo, Ty,
              isLocalToUnit, isDefinition, VK,
              VIndex, ThisAdjustment,
              VTableHolder, Flags, isOptimized,
              new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public DISubprogram /*P*/ createMethod(DIScope /*P*/ Context, StringRef Name, StringRef LinkageName,
              DIFile /*P*/ F, /*uint*/int LineNo, DISubroutineType /*P*/ Ty,
              boolean isLocalToUnit, boolean isDefinition, /*uint*/int VK/*= 0*/,
              /*uint*/int VIndex/*= 0*/, int ThisAdjustment/*= 0*/,
              DIType /*P*/ VTableHolder/*= null*/, /*uint*/int Flags/*= 0*/, boolean isOptimized/*= false*/,
              MDTupleTypedArrayWrapper<DITemplateParameter> TParams/*= null*/) {
    assert ((DIBuilderStatics.getNonCompileUnitScope(Context) != null)) : "Methods should have both a Context and a context that isn't the compile unit.";
    // FIXME: Do we want to use different scope/lines?
    DISubprogram /*P*/ SP = DIBuilderStatics.getSubprogram(/* IsDistinct = */ isDefinition, VMContext, cast_DIScope(Context), Name,
        LinkageName, F, LineNo, Ty, isLocalToUnit, isDefinition, LineNo,
        VTableHolder, VK, VIndex, ThisAdjustment, Flags, isOptimized,
        isDefinition ? CUNode : (DICompileUnit /*P*/ )null, TParams, null, null);
    if (isDefinition) {
      AllSubprograms.push_back(SP);
    }
    trackIfUnresolved(SP);
    return SP;
  }


  /// This creates new descriptor for a namespace with the specified
  /// parent scope.
  /// \param Scope       Namespace scope
  /// \param Name        Name of this namespace
  /// \param File        Source file
  /// \param LineNo      Line number
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createNameSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 682,
   FQN="llvm::DIBuilder::createNameSpace", NM="_ZN4llvm9DIBuilder15createNameSpaceEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder15createNameSpaceEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEj")
  //</editor-fold>
  public DINamespace /*P*/ createNameSpace(DIScope /*P*/ Scope, StringRef Name,
                 DIFile /*P*/ File, /*uint*/int LineNo) {
    return DINamespace.get(VMContext, DIBuilderStatics.getNonCompileUnitScope(Scope), File, new StringRef(Name),
        LineNo);
  }


  /// This creates new descriptor for a module with the specified
  /// parent scope.
  /// \param Scope       Parent scope
  /// \param Name        Name of this module
  /// \param ConfigurationMacros
  ///                    A space-separated shell-quoted list of -D macro
  ///                    definitions as they would appear on a command line.
  /// \param IncludePath The path to the module map file.
  /// \param ISysRoot    The clang system root (value of -isysroot).
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 688,
   FQN="llvm::DIBuilder::createModule", NM="_ZN4llvm9DIBuilder12createModuleEPNS_7DIScopeENS_9StringRefES3_S3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder12createModuleEPNS_7DIScopeENS_9StringRefES3_S3_S3_")
  //</editor-fold>
  public DIModule /*P*/ createModule(DIScope /*P*/ Scope, StringRef Name,
              StringRef ConfigurationMacros,
              StringRef IncludePath,
              StringRef ISysRoot) {
    return DIModule.get(VMContext, DIBuilderStatics.getNonCompileUnitScope(Scope), new StringRef(Name),
        new StringRef(ConfigurationMacros), new StringRef(IncludePath), new StringRef(ISysRoot));
  }


  /// This creates a descriptor for a lexical block with a new file
  /// attached. This merely extends the existing
  /// lexical block as it crosses a file.
  /// \param Scope       Lexical block.
  /// \param File        Source file.
  /// \param Discriminator DWARF path discriminator value.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createLexicalBlockFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 696,
   FQN="llvm::DIBuilder::createLexicalBlockFile", NM="_ZN4llvm9DIBuilder22createLexicalBlockFileEPNS_7DIScopeEPNS_6DIFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder22createLexicalBlockFileEPNS_7DIScopeEPNS_6DIFileEj")
  //</editor-fold>
  public DILexicalBlockFile /*P*/ createLexicalBlockFile(DIScope /*P*/ Scope,
                        DIFile /*P*/ File) {
    return createLexicalBlockFile(Scope,
                        File,
                        0);
  }
  public DILexicalBlockFile /*P*/ createLexicalBlockFile(DIScope /*P*/ Scope,
                        DIFile /*P*/ File,
                        /*uint*/int Discriminator/*= 0*/) {
    return DILexicalBlockFile.get(VMContext, Scope, File, Discriminator);
  }


  /// This creates a descriptor for a lexical block with the
  /// specified parent context.
  /// \param Scope         Parent lexical scope.
  /// \param File          Source file.
  /// \param Line          Line number.
  /// \param Col           Column number.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createLexicalBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 702,
   FQN="llvm::DIBuilder::createLexicalBlock", NM="_ZN4llvm9DIBuilder18createLexicalBlockEPNS_7DIScopeEPNS_6DIFileEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder18createLexicalBlockEPNS_7DIScopeEPNS_6DIFileEjj")
  //</editor-fold>
  public DILexicalBlock /*P*/ createLexicalBlock(DIScope /*P*/ Scope, DIFile /*P*/ File,
                    /*uint*/int Line, /*uint*/int Col) {
    // Make these distinct, to avoid merging two lexical blocks on the same
    // file/line/column.
    return DILexicalBlock.getDistinct(VMContext, DIBuilderStatics.getNonCompileUnitScope(Scope),
        File, Line, Col);
  }


  /// Create a descriptor for an imported module.
  /// \param Context The scope this module is imported into
  /// \param NS The namespace being imported here
  /// \param Line Line number
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createImportedModule">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 148,
   FQN="llvm::DIBuilder::createImportedModule", NM="_ZN4llvm9DIBuilder20createImportedModuleEPNS_7DIScopeEPNS_11DINamespaceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder20createImportedModuleEPNS_7DIScopeEPNS_11DINamespaceEj")
  //</editor-fold>
  public DIImportedEntity /*P*/ createImportedModule(DIScope /*P*/ Context,
                      DINamespace /*P*/ NS,
                      /*uint*/int Line) {
    return /*::*/DIBuilderStatics.createImportedModule(VMContext, Tag.DW_TAG_imported_module,
        Context, NS, Line, new StringRef(), AllImportedModules);
  }


  /// Create a descriptor for an imported module.
  /// \param Context The scope this module is imported into
  /// \param NS An aliased namespace
  /// \param Line Line number
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createImportedModule">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 155,
   FQN="llvm::DIBuilder::createImportedModule", NM="_ZN4llvm9DIBuilder20createImportedModuleEPNS_7DIScopeEPNS_16DIImportedEntityEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder20createImportedModuleEPNS_7DIScopeEPNS_16DIImportedEntityEj")
  //</editor-fold>
  public DIImportedEntity /*P*/ createImportedModule(DIScope /*P*/ Context,
                      DIImportedEntity /*P*/ NS,
                      /*uint*/int Line) {
    return /*::*/DIBuilderStatics.createImportedModule(VMContext, Tag.DW_TAG_imported_module,
        Context, NS, Line, new StringRef(), AllImportedModules);
  }


  /// Create a descriptor for an imported module.
  /// \param Context The scope this module is imported into
  /// \param M The module being imported here
  /// \param Line Line number
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createImportedModule">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 162,
   FQN="llvm::DIBuilder::createImportedModule", NM="_ZN4llvm9DIBuilder20createImportedModuleEPNS_7DIScopeEPNS_8DIModuleEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder20createImportedModuleEPNS_7DIScopeEPNS_8DIModuleEj")
  //</editor-fold>
  public DIImportedEntity /*P*/ createImportedModule(DIScope /*P*/ Context, DIModule /*P*/ M,
                      /*uint*/int Line) {
    return /*::*/DIBuilderStatics.createImportedModule(VMContext, Tag.DW_TAG_imported_module,
        Context, M, Line, new StringRef(), AllImportedModules);
  }


  /// Create a descriptor for an imported function.
  /// \param Context The scope this module is imported into
  /// \param Decl The declaration (or definition) of a function, type, or
  ///             variable
  /// \param Line Line number
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::createImportedDeclaration">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 168,
   FQN="llvm::DIBuilder::createImportedDeclaration", NM="_ZN4llvm9DIBuilder25createImportedDeclarationEPNS_7DIScopeEPNS_6DINodeEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder25createImportedDeclarationEPNS_7DIScopeEPNS_6DINodeEjNS_9StringRefE")
  //</editor-fold>
  public DIImportedEntity /*P*/ createImportedDeclaration(DIScope /*P*/ Context,
                           DINode /*P*/ Decl,
                           /*uint*/int Line) {
    return createImportedDeclaration(Context,
                           Decl,
                           Line,
                           new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public DIImportedEntity /*P*/ createImportedDeclaration(DIScope /*P*/ Context,
                           DINode /*P*/ Decl,
                           /*uint*/int Line,
                           StringRef Name/*= ""*/) {
    // Make sure to use the unique identifier based metadata reference for
    // types that have one.
    return /*::*/DIBuilderStatics.createImportedModule(VMContext, Tag.DW_TAG_imported_declaration,
        Context, Decl, Line, new StringRef(Name), AllImportedModules);
  }


  /// Insert a new llvm.dbg.declare intrinsic call.
  /// \param Storage     llvm::Value of the variable
  /// \param VarInfo     Variable's debug info descriptor.
  /// \param Expr        A complex location expression.
  /// \param DL          Debug info location.
  /// \param InsertAtEnd Location for the new intrinsic.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::insertDeclare">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 739,
   FQN="llvm::DIBuilder::insertDeclare", NM="_ZN4llvm9DIBuilder13insertDeclareEPNS_5ValueEPNS_15DILocalVariableEPNS_12DIExpressionEPKNS_10DILocationEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder13insertDeclareEPNS_5ValueEPNS_15DILocalVariableEPNS_12DIExpressionEPKNS_10DILocationEPNS_10BasicBlockE")
  //</editor-fold>
  public Instruction /*P*/ insertDeclare_1(Value /*P*/ Storage, DILocalVariable /*P*/ VarInfo,
                 DIExpression /*P*/ Expr, /*const*/ DILocation /*P*/ DL,
                 BasicBlock /*P*/ InsertAtEnd) {
    assert ((VarInfo != null)) : "empty or invalid DILocalVariable* passed to dbg.declare";
    assert ((DL != null)) : "Expected debug loc";
    assert (DL.getScope().getSubprogram() == VarInfo.getScope().getSubprogram()) : "Expected matching subprograms";
    if (!(DeclareFn != null)) {
      DeclareFn = getDeclaration($AddrOf(M), ID.dbg_declare);
    }

    trackIfUnresolved(VarInfo);
    trackIfUnresolved(Expr);
    Value /*P*/ Args[/*3*/] = new Value /*P*/  [/*3*/] {
      DIBuilderStatics.getDbgIntrinsicValueImpl(VMContext, Storage),
      MetadataAsValue.get(VMContext, VarInfo),
      MetadataAsValue.get(VMContext, Expr)};
    {

      // If this block already has a terminator then insert this intrinsic
      // before the terminator.
      TerminatorInst /*P*/ T = InsertAtEnd.getTerminator();
      if ((T != null)) {
        return DIBuilderStatics.withDebugLoc(CallInst.Create_Value2(DeclareFn, new ArrayRef<Value /*P*/ >(Args, true), new Twine(/*KEEP_STR*/$EMPTY), T), DL);
      }
    }
    return DIBuilderStatics.withDebugLoc(CallInst.Create_Value4(DeclareFn, new ArrayRef<Value /*P*/ >(Args, true), new Twine(/*KEEP_STR*/$EMPTY), InsertAtEnd), DL);
  }


  /// Insert a new llvm.dbg.declare intrinsic call.
  /// \param Storage      llvm::Value of the variable
  /// \param VarInfo      Variable's debug info descriptor.
  /// \param Expr         A complex location expression.
  /// \param DL           Debug info location.
  /// \param InsertBefore Location for the new intrinsic.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::insertDeclare">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 720,
   FQN="llvm::DIBuilder::insertDeclare", NM="_ZN4llvm9DIBuilder13insertDeclareEPNS_5ValueEPNS_15DILocalVariableEPNS_12DIExpressionEPKNS_10DILocationEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder13insertDeclareEPNS_5ValueEPNS_15DILocalVariableEPNS_12DIExpressionEPKNS_10DILocationEPNS_11InstructionE")
  //</editor-fold>
  public Instruction /*P*/ insertDeclare_2(Value /*P*/ Storage, DILocalVariable /*P*/ VarInfo,
                 DIExpression /*P*/ Expr, /*const*/ DILocation /*P*/ DL,
                 Instruction /*P*/ InsertBefore) {
    assert ((VarInfo != null)) : "empty or invalid DILocalVariable* passed to dbg.declare";
    assert ((DL != null)) : "Expected debug loc";
    assert (DL.getScope().getSubprogram() == VarInfo.getScope().getSubprogram()) : "Expected matching subprograms";
    if (!(DeclareFn != null)) {
      DeclareFn = getDeclaration($AddrOf(M), ID.dbg_declare);
    }

    trackIfUnresolved(VarInfo);
    trackIfUnresolved(Expr);
    Value /*P*/ Args[/*3*/] = new Value /*P*/  [/*3*/] {
      DIBuilderStatics.getDbgIntrinsicValueImpl(VMContext, Storage),
      MetadataAsValue.get(VMContext, VarInfo),
      MetadataAsValue.get(VMContext, Expr)};
    return DIBuilderStatics.withDebugLoc(CallInst.Create_Value2(DeclareFn, new ArrayRef<Value /*P*/ >(Args, true), new Twine(/*KEEP_STR*/$EMPTY), InsertBefore), DL);
  }


  /// Insert a new llvm.dbg.value intrinsic call.
  /// \param Val          llvm::Value of the variable
  /// \param Offset       Offset
  /// \param VarInfo      Variable's debug info descriptor.
  /// \param Expr         A complex location expression.
  /// \param DL           Debug info location.
  /// \param InsertAtEnd Location for the new intrinsic.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::insertDbgValueIntrinsic">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 786,
   FQN="llvm::DIBuilder::insertDbgValueIntrinsic", NM="_ZN4llvm9DIBuilder23insertDbgValueIntrinsicEPNS_5ValueEyPNS_15DILocalVariableEPNS_12DIExpressionEPKNS_10DILocationEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder23insertDbgValueIntrinsicEPNS_5ValueEyPNS_15DILocalVariableEPNS_12DIExpressionEPKNS_10DILocationEPNS_10BasicBlockE")
  //</editor-fold>
  public Instruction /*P*/ insertDbgValueIntrinsic_1(Value /*P*/ V, long/*uint64_t*/ Offset,
                           DILocalVariable /*P*/ VarInfo,
                           DIExpression /*P*/ Expr,
                           /*const*/ DILocation /*P*/ DL,
                           BasicBlock /*P*/ InsertAtEnd) {
    assert ((V != null)) : "no value passed to dbg.value";
    assert ((VarInfo != null)) : "empty or invalid DILocalVariable* passed to dbg.value";
    assert ((DL != null)) : "Expected debug loc";
    assert (DL.getScope().getSubprogram() == VarInfo.getScope().getSubprogram()) : "Expected matching subprograms";
    if (!(ValueFn != null)) {
      ValueFn = getDeclaration($AddrOf(M), ID.dbg_value);
    }

    trackIfUnresolved(VarInfo);
    trackIfUnresolved(Expr);
    Value /*P*/ Args[/*4*/] = new Value /*P*/  [/*4*/] {
      DIBuilderStatics.getDbgIntrinsicValueImpl(VMContext, V),
      ConstantInt.get(Type.getInt64Ty(VMContext), Offset),
      MetadataAsValue.get(VMContext, VarInfo),
      MetadataAsValue.get(VMContext, Expr)};

    return DIBuilderStatics.withDebugLoc(CallInst.Create_Value4(ValueFn, new ArrayRef<Value /*P*/ >(Args, true), new Twine(/*KEEP_STR*/$EMPTY), InsertAtEnd), DL);
  }


  /// Insert a new llvm.dbg.value intrinsic call.
  /// \param Val          llvm::Value of the variable
  /// \param Offset       Offset
  /// \param VarInfo      Variable's debug info descriptor.
  /// \param Expr         A complex location expression.
  /// \param DL           Debug info location.
  /// \param InsertBefore Location for the new intrinsic.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::insertDbgValueIntrinsic">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 763,
   FQN="llvm::DIBuilder::insertDbgValueIntrinsic", NM="_ZN4llvm9DIBuilder23insertDbgValueIntrinsicEPNS_5ValueEyPNS_15DILocalVariableEPNS_12DIExpressionEPKNS_10DILocationEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder23insertDbgValueIntrinsicEPNS_5ValueEyPNS_15DILocalVariableEPNS_12DIExpressionEPKNS_10DILocationEPNS_11InstructionE")
  //</editor-fold>
  public Instruction /*P*/ insertDbgValueIntrinsic_2(Value /*P*/ V, long/*uint64_t*/ Offset,
                           DILocalVariable /*P*/ VarInfo,
                           DIExpression /*P*/ Expr,
                           /*const*/ DILocation /*P*/ DL,
                           Instruction /*P*/ InsertBefore) {
    assert ((V != null)) : "no value passed to dbg.value";
    assert ((VarInfo != null)) : "empty or invalid DILocalVariable* passed to dbg.value";
    assert ((DL != null)) : "Expected debug loc";
    assert (DL.getScope().getSubprogram() == VarInfo.getScope().getSubprogram()) : "Expected matching subprograms";
    if (!(ValueFn != null)) {
      ValueFn = getDeclaration($AddrOf(M), ID.dbg_value);
    }

    trackIfUnresolved(VarInfo);
    trackIfUnresolved(Expr);
    Value /*P*/ Args[/*4*/] = new Value /*P*/  [/*4*/] {
      DIBuilderStatics.getDbgIntrinsicValueImpl(VMContext, V),
      ConstantInt.get(Type.getInt64Ty(VMContext), Offset),
      MetadataAsValue.get(VMContext, VarInfo),
      MetadataAsValue.get(VMContext, Expr)};
    return DIBuilderStatics.withDebugLoc(CallInst.Create_Value2(ValueFn, new ArrayRef<Value /*P*/ >(Args, true), new Twine(/*KEEP_STR*/$EMPTY), InsertBefore), DL);
  }


  /// Replace the vtable holder in the given composite type.
  ///
  /// If this creates a self reference, it may orphan some unresolved cycles
  /// in the operands of \c T, so \a DIBuilder needs to track that.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::replaceVTableHolder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 810,
   FQN="llvm::DIBuilder::replaceVTableHolder", NM="_ZN4llvm9DIBuilder19replaceVTableHolderERPNS_15DICompositeTypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder19replaceVTableHolderERPNS_15DICompositeTypeES2_")
  //</editor-fold>
  public void replaceVTableHolder(final type$ref<DICompositeType /*P*/ /*&*/> T,
                     DICompositeType /*P*/ VTableHolder) {
    {
      TypedTrackingMDRef<DICompositeType> N = null;
      try {
        N/*J*/= new TypedTrackingMDRef<DICompositeType>(T.$deref());
        N.$arrow().replaceVTableHolder(new TypedDINodeRef<DIType>(DIType.class, VTableHolder));
        T.$set(N.get());
      } finally {
        if (N != null) { N.$destroy(); }
      }
    }

    // If this didn't create a self-reference, just return.
    if (T.$deref() != VTableHolder) {
      return;
    }

    // Look for unresolved operands.  T will drop RAUW support, orphaning any
    // cycles underneath it.
    if (T.$deref().isResolved()) {
      for (final /*const*/ MDOperand /*&*/ O : T.$deref().operands())  {
        {
          MDNode /*P*/ N = dyn_cast_or_null_MDNode(O);
          if ((N != null)) {
            trackIfUnresolved(N);
          }
        }
      }
    }
  }


  /// Replace arrays on a composite type.
  ///
  /// If \c T is resolved, but the arrays aren't -- which can happen if \c T
  /// has a self-reference -- \a DIBuilder needs to track the array to
  /// resolve cycles.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::replaceArrays">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 830,
   FQN="llvm::DIBuilder::replaceArrays", NM="_ZN4llvm9DIBuilder13replaceArraysERPNS_15DICompositeTypeENS_24MDTupleTypedArrayWrapperINS_6DINodeEEES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZN4llvm9DIBuilder13replaceArraysERPNS_15DICompositeTypeENS_24MDTupleTypedArrayWrapperINS_6DINodeEEES6_")
  //</editor-fold>
  public void replaceArrays(final type$ref<DICompositeType /*P*/ /*&*/> T, MDTupleTypedArrayWrapper<DINode> Elements) {
    replaceArrays(T, Elements,
               new MDTupleTypedArrayWrapper<DINode>(DINode.class));
  }
  public void replaceArrays(final type$ref<DICompositeType /*P*/ /*&*/> T, MDTupleTypedArrayWrapper<DINode> Elements,
               MDTupleTypedArrayWrapper<DINode> TParams/*= DINodeArray()*/) {
    {
      TypedTrackingMDRef<DICompositeType> N = null;
      try {
        N/*J*/= new TypedTrackingMDRef<DICompositeType>(T.$deref());
        if (Elements.$bool()) {
          N.$arrow().replaceElements(new MDTupleTypedArrayWrapper<DINode>(Elements));
        }
        if (TParams.$bool()) {
          N.$arrow().replaceTemplateParams(new MDTupleTypedArrayWrapper<DITemplateParameter>(JD$NotConvertible.INSTANCE, DITemplateParameter.class, TParams));
        }
        T.$set(N.get());
      } finally {
        if (N != null) { N.$destroy(); }
      }
    }

    // If T isn't resolved, there's no problem.
    if (!T.$deref().isResolved()) {
      return;
    }

    // If T is resolved, it may be due to a self-reference cycle.  Track the
    // arrays explicitly if they're unresolved, or else the cycles will be
    // orphaned.
    if (Elements.$bool()) {
      trackIfUnresolved(Elements.get());
    }
    if (TParams.$bool()) {
      trackIfUnresolved(TParams.get());
    }
  }


  /// Replace a temporary node.
  ///
  /// Call \a MDNode::replaceAllUsesWith() on \c N, replacing it with \c
  /// Replacement.
  ///
  /// If \c Replacement is the same as \c N.get(), instead call \a
  /// MDNode::replaceWithUniqued().  In this case, the uniqued node could
  /// have a different address, so we return the final address.
  /*template <class NodeTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::replaceTemporary">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DIBuilder.h", line = 721,
   FQN="llvm::DIBuilder::replaceTemporary", NM="Tpl__ZN4llvm9DIBuilder16replaceTemporaryEOSt10unique_ptrINS_6MDNodeENS_17TempMDNodeDeleterEEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=Tpl__ZN4llvm9DIBuilder16replaceTemporaryEOSt10unique_ptrINS_6MDNodeENS_17TempMDNodeDeleterEEPT_")
  //</editor-fold>
  public </*class*/ NodeTy extends MDNode> NodeTy /*P*/ replaceTemporary(final std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/> /*&*/ N, NodeTy /*P*/ Replacement) {
    if (Native.$eq(N.get(), Replacement)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean((NodeTy)(MDNode.replaceWithUniqued$BaseOfMDNode($c$.track(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Move.INSTANCE, std.move(N))))));
      } finally {
        $c$.$destroy();
      }
    }

    N.$arrow().replaceAllUsesWith(Replacement);
    return Replacement;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIBuilder::~DIBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DIBuilder.h", line = 34,
   FQN="llvm::DIBuilder::~DIBuilder", NM="_ZN4llvm9DIBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm9DIBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    PreservedVariables.$destroy();
    UnresolvedNodes.$destroy();
    AllImportedModules.$destroy();
    AllGVs.$destroy();
    AllSubprograms.$destroy();
    AllRetainTypes.$destroy();
    AllEnumTypes.$destroy();
    //END JDestroy
  }



  @Override public String toString() {
    return "" + "M=" + M // NOI18N
              + ", VMContext=" + "[LLVMContext]" // NOI18N
              + ", CUNode=" + CUNode // NOI18N
              + ", DeclareFn=" + DeclareFn // NOI18N
              + ", ValueFn=" + ValueFn // NOI18N
              + ", AllEnumTypes=" + AllEnumTypes // NOI18N
              + ", AllRetainTypes=" + AllRetainTypes // NOI18N
              + ", AllSubprograms=" + AllSubprograms // NOI18N
              + ", AllGVs=" + AllGVs // NOI18N
              + ", AllImportedModules=" + AllImportedModules // NOI18N
              + ", UnresolvedNodes=" + UnresolvedNodes // NOI18N
              + ", AllowUnresolvedNodes=" + AllowUnresolvedNodes // NOI18N
              + ", PreservedVariables=" + PreservedVariables; // NOI18N
  }
}

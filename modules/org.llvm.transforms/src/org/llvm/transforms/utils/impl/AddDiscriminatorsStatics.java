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
package org.llvm.transforms.utils.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.JD$Pair$_U1$_U2;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.$less_uint;
import org.clank.support.aliases.type$ref;
import org.llvm.adt.DenseMapInfoPairTypeUInt;
import org.llvm.adt.StringRef;
import org.llvm.adt.aliases.DenseMap;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;
import org.llvm.adt.aliases.DenseMapInfoStringRef;
import org.llvm.adt.aliases.DenseMapIterator;
import org.llvm.adt.aliases.DenseMapTypeUInt;
import org.llvm.adt.aliases.DenseSet;
import org.llvm.cl.ClGlobals;
import org.llvm.cl.aliases.optBool;
import org.llvm.cl.desc;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.dyn_cast_CallInst;
import static org.llvm.ir.java.IrRTTI.dyn_cast_DILexicalBlockFile;
import static org.llvm.ir.java.IrRTTI.isa_DbgInfoIntrinsic;
import org.llvm.pass.*;
import static org.llvm.pass.IrLlvmGlobals.$out_raw_ostream_Value$C;
import org.llvm.support.llvm;
import static org.llvm.support.llvm.dbgs;


//<editor-fold defaultstate="collapsed" desc="static type AddDiscriminatorsStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.transforms.utils.impl.AddDiscriminatorsStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/AddDiscriminators.cpp -nm=_ZL16NoDiscriminators;_ZL17addDiscriminatorsRN4llvm8FunctionE;_ZL45InitializeAddDiscriminatorsLegacyPassPassFlag;_ZL45initializeAddDiscriminatorsLegacyPassPassOnceRN4llvm12PassRegistryE; -static-type=AddDiscriminatorsStatics -package=org.llvm.transforms.utils.impl")
//</editor-fold>
public final class AddDiscriminatorsStatics {

//<editor-fold defaultstate="collapsed" desc="initializeAddDiscriminatorsLegacyPassPassOnce">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/AddDiscriminators.cpp", line = 90,
 FQN="initializeAddDiscriminatorsLegacyPassPassOnce", NM="_ZL45initializeAddDiscriminatorsLegacyPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/AddDiscriminators.cpp -nm=_ZL45initializeAddDiscriminatorsLegacyPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeAddDiscriminatorsLegacyPassPassOnce(final PassRegistry /*&*/ Registry) {
  PassInfo /*P*/ PI = new PassInfo($("Add DWARF path discriminators"), $("add-discriminators"), $AddrOf(AddDiscriminatorsLegacyPass.ID), 
          () -> new AddDiscriminatorsLegacyPass(),
//          ((NormalCtor_t)(/*FuncRef*/<AddDiscriminatorsLegacyPass>callDefaultCtor)), 
          false, false);
  Registry.registerPass($Deref(PI), true);
  return PI;
}

//<editor-fold defaultstate="collapsed" desc="InitializeAddDiscriminatorsLegacyPassPassFlag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/AddDiscriminators.cpp", line = 92,
 FQN="InitializeAddDiscriminatorsLegacyPassPassFlag", NM="_ZL45InitializeAddDiscriminatorsLegacyPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/AddDiscriminators.cpp -nm=_ZL45InitializeAddDiscriminatorsLegacyPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeAddDiscriminatorsLegacyPassPassFlag/*J*/= new std.once_flag();

// Command line option to disable discriminator generation even in the
// presence of debug information. This is only needed when debugging
// debug info generation issues.
//<editor-fold defaultstate="collapsed" desc="NoDiscriminators">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/AddDiscriminators.cpp", line = 98,
 FQN="NoDiscriminators", NM="_ZL16NoDiscriminators",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/AddDiscriminators.cpp -nm=_ZL16NoDiscriminators")
//</editor-fold>
public static optBool NoDiscriminators/*J*/= new optBool(/*false,*/ $("no-discriminators"), ClGlobals.init$Bool(false), 
    new desc($("Disable generation of discriminator information.")));

/// \brief Assign DWARF discriminators.
///
/// To assign discriminators, we examine the boundaries of every
/// basic block and its successors. Suppose there is a basic block B1
/// with successor B2. The last instruction I1 in B1 and the first
/// instruction I2 in B2 are located at the same file and line number.
/// This situation is illustrated in the following code snippet:
///
///       if (i < 10) x = i;
///
///     entry:
///       br i1 %cmp, label %if.then, label %if.end, !dbg !10
///     if.then:
///       %1 = load i32* %i.addr, align 4, !dbg !10
///       store i32 %1, i32* %x, align 4, !dbg !10
///       br label %if.end, !dbg !10
///     if.end:
///       ret void, !dbg !12
///
/// Notice how the branch instruction in block 'entry' and all the
/// instructions in block 'if.then' have the exact same debug location
/// information (!dbg !10).
///
/// To distinguish instructions in block 'entry' from instructions in
/// block 'if.then', we generate a new lexical block for all the
/// instruction in block 'if.then' that share the same file and line
/// location with the last instruction of block 'entry'.
///
/// This new lexical block will have the same location information as
/// the previous one, but with a new DWARF discriminator value.
///
/// One of the main uses of this discriminator value is in runtime
/// sample profilers. It allows the profiler to distinguish instructions
/// at location !dbg !10 that execute on different basic blocks. This is
/// important because while the predicate 'if (x < 10)' may have been
/// executed millions of times, the assignment 'x = i' may have only
/// executed a handful of times (meaning that the entry->if.then edge is
/// seldom taken).
///
/// If we did not have discriminator information, the profiler would
/// assign the same weight to both blocks 'entry' and 'if.then', which
/// in turn will make it conclude that the entry->if.then edge is very
/// hot.
///
/// To decide where to create new discriminator values, this function
/// traverses the CFG and examines instruction at basic block boundaries.
/// If the last instruction I1 of a block B1 is at the same file and line
/// location as instruction I2 of successor B2, then it creates a new
/// lexical block for I2 and all the instruction in B2 that share the same
/// file and line location as I2. This new lexical block will have a
/// different discriminator number than I1.
//<editor-fold defaultstate="collapsed" desc="addDiscriminators">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/AddDiscriminators.cpp", line = 158,
 FQN="addDiscriminators", NM="_ZL17addDiscriminatorsRN4llvm8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/AddDiscriminators.cpp -nm=_ZL17addDiscriminatorsRN4llvm8FunctionE")
//</editor-fold>
public static boolean addDiscriminators(final Function /*&*/ F) {
  DIBuilder Builder = null;
  DenseMap<std.pairTypeUInt<StringRef>, DenseMap</*const*/ BasicBlock /*P*/ , Metadata /*P*/ >> LBM = null;
  try {
    // If the function has debug information, but the user has disabled
    // discriminators, do nothing.
    // Simlarly, if the function has no debug info, do nothing.
    // Finally, if this module is built with dwarf versions earlier than 4,
    // do nothing (discriminator support is a DWARF 4 feature).
    if (AddDiscriminatorsStatics.NoDiscriminators.$T() || !(F.getSubprogram() != null)
       || $less_uint(F.getParent().getDwarfVersion(), 4)) {
      return false;
    }
    
    boolean Changed = false;
    Module /*P*/ M = F.getParent();
    final LLVMContext /*&*/ Ctx = M.getContext();
    Builder/*J*/= new DIBuilder($Deref(M), /*AllowUnresolved*/ false);
    
    // JAVA: typedef std::pair<StringRef, unsigned int> Location
//    final class Location extends std.pairTypeUInt<StringRef>{ };
    // JAVA: typedef DenseMap<const BasicBlock *, Metadata *> BBScopeMap
//    final class BBScopeMap extends DenseMap</*const*/ BasicBlock /*P*/ , Metadata /*P*/ >{ };
    // JAVA: typedef DenseMap<Location, BBScopeMap> LocationBBMap
//    final class LocationBBMap extends DenseMap<std.pairTypeUInt<StringRef>, DenseMap</*const*/ BasicBlock /*P*/ , Metadata /*P*/ >>{ };
    // JAVA: typedef DenseMap<Location, unsigned int> LocationDiscriminatorMap
//    final class LocationDiscriminatorMap extends DenseMapTypeUInt<std.pairTypeUInt<StringRef>>{ };
    // JAVA: typedef DenseSet<Location> LocationSet
//    final class LocationSet extends DenseSet<std.pairTypeUInt<StringRef>>{ };
    
    LBM/*J*/= new DenseMap<std.pairTypeUInt<StringRef>, DenseMap</*const*/ BasicBlock /*P*/ , Metadata /*P*/ >>(DMI_PAIR_STRINGREF_UINT, new DenseMap</*const*/ BasicBlock /*P*/ , Metadata /*P*/ >(DenseMapInfo$LikePtr.<BasicBlock/*P*/>$Info(), (Metadata/*P*/)null));
    DenseMapTypeUInt<std.pairTypeUInt<StringRef>> LDM/*J*/= new DenseMapTypeUInt<std.pairTypeUInt<StringRef>>(DMI_PAIR_STRINGREF_UINT, 0);
    
    // Traverse all instructions in the function. If the source line location
    // of the instruction appears in other basic block, assign a new
    // discriminator for this instruction.
    for (final BasicBlock /*&*/ B : F) {
      for (final Instruction /*&*/ I : B.getInstList()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (isa_DbgInfoIntrinsic($AddrOf(I))) {
            continue;
          }
          /*const*/ DILocation /*P*/ DIL = I.getDebugLoc().$DILocation$P();
          if (!(DIL != null)) {
            continue;
          }
          std.pairTypeUInt<StringRef> L = std.make_pair_T_uint($Move(DIL.getFilename()), DIL.getLine());
          final DenseMap<BasicBlock/*P*/, Metadata/*P*/> BBMap = LBM.$at_T1$C$R(L);
          std.pairTypeBool<DenseMapIterator</*const*/ BasicBlock /*P*/ , Metadata /*P*/ >> R = BBMap.insert_pair$KeyT$ValueT(new std.pairPtrPtr</*const*/ BasicBlock /*P*/ , Metadata /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/$AddrOf(B), /*Fwd2*//*Fwd*/(Metadata /*P*/ )(Metadata /*P*/ )null));
          if (BBMap.size() == 1) {
            continue;
          }
          boolean InsertSuccess = R.second;
          final type$ref<Metadata /*P*/ /*&*/> NewScope = R.first.$arrow().second$ref();
          // If we could insert a different block in the same location, a
          // discriminator is needed to distinguish both instructions.
          if (InsertSuccess) {
            DILocalScope /*P*/ Scope = DIL.getScope();
            DIFile /*P*/ File = Builder.createFile(DIL.getFilename(), Scope.getDirectory());
            NewScope.$set(Builder.createLexicalBlockFile(Scope, File, LDM.ref$at(L).$set$preInc()));
          }
          I.setDebugLoc($c$.track(new DebugLoc(DILocation.get(Ctx, DIL.getLine(), DIL.getColumn(), 
                      NewScope.$deref(), DIL.getInlinedAt())))); $c$.clean();
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"add-discriminators")) {
              $out_raw_ostream_Value$C(dbgs().$out(DIL.getFilename()).$out(/*KEEP_STR*/$COLON).$out_uint(DIL.getLine()).$out(/*KEEP_STR*/$COLON).$out_uint(DIL.getColumn()).$out(/*KEEP_STR*/$COLON).$out_uint(dyn_cast_DILexicalBlockFile(NewScope.$deref()).getDiscriminator()), I).$out(/*KEEP_STR*/$LF);
            }
          } while (false);
          Changed = true;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Traverse all instructions and assign new discriminators to call
    // instructions with the same lineno that are in the same basic block.
    // Sample base profile needs to distinguish different function calls within
    // a same source line for correct profile annotation.
    for (final BasicBlock /*&*/ B : F) {
      DenseSet<std.pairTypeUInt<StringRef>> CallLocations/*J*/= new DenseSet<std.pairTypeUInt<StringRef>>(DMI_PAIR_STRINGREF_UINT);
      for (final Instruction /*&*/ I : B.getInstList()) {
        CallInst /*P*/ Current = dyn_cast_CallInst($AddrOf(I));
        if (!(Current != null) || isa_DbgInfoIntrinsic($AddrOf(I))) {
          continue;
        }
        
        DILocation /*P*/ CurrentDIL = Current.getDebugLoc().$DILocation$P();
        if (!(CurrentDIL != null)) {
          continue;
        }
        std.pairTypeUInt<StringRef> L = std.make_pair_T_uint($Move(CurrentDIL.getFilename()), CurrentDIL.getLine());
        if (!CallLocations.insert(L).second) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            DILocalScope /*P*/ Scope = CurrentDIL.getScope();
            DIFile /*P*/ File = Builder.createFile(CurrentDIL.getFilename(), 
                Scope.getDirectory());
            DILexicalBlockFile /*P*/ NewScope = Builder.createLexicalBlockFile(Scope, File, LDM.ref$at(L).$set$preInc());
            Current.setDebugLoc($c$.track(new DebugLoc(DILocation.get(Ctx, CurrentDIL.getLine(), 
                        CurrentDIL.getColumn(), NewScope, 
                        CurrentDIL.getInlinedAt())))); $c$.clean();
            Changed = true;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    return Changed;
  } finally {
    if (LBM != null) { LBM.$destroy(); }
    if (Builder != null) { Builder.$destroy(); }
  }
}
  
public static final DenseMapInfoPairTypeUInt DMI_PAIR_STRINGREF_UINT = new DenseMapInfoPairTypeUInt(DenseMapInfoStringRef.$Info());

} // END OF class AddDiscriminatorsStatics

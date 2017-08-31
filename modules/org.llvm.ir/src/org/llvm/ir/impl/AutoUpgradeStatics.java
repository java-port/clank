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
package org.llvm.ir.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.java.*;
import static org.llvm.ir.intrinsic.IntrinsicGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type AutoUpgradeStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.AutoUpgradeStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZL13EmitX86SelectRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueES6_S6_;_ZL13getX86MaskVecRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueEj;_ZL14upgradeLoopTagRN4llvm11LLVMContextENS_9StringRefE;_ZL16upgradeIntMinMaxRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERNS_8CallInstENS_7CmpInst9PredicateE;_ZL17UpgradeMaskedLoadRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueES6_S6_b;_ZL17isOldLoopArgumentPN4llvm8MetadataE;_ZL18UpgradeMaskedStoreRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueES6_S6_b;_ZL19upgradeLoopArgumentPN4llvm8MetadataE;_ZL20UpgradeSSE41FunctionPN4llvm8FunctionENS_9Intrinsic2IDERS1_;_ZL20upgradeMaskedCompareRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERNS_8CallInstENS_7CmpInst9PredicateE;_ZL25UpgradeIntrinsicFunction1PN4llvm8FunctionERS1_;_ZL26UpgradeX86PSLLDQIntrinsicsRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueEj;_ZL26UpgradeX86PSRLDQIntrinsicsRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueEj;_ZL27UpgradeX86PALIGNRIntrinsicsRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueES6_S6_S6_S6_;_ZL32UpgradeX86IntrinsicsWith8BitMaskPN4llvm8FunctionENS_9Intrinsic2IDERS1_; -static-type=AutoUpgradeStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class AutoUpgradeStatics {


// Upgrade the declarations of the SSE4.1 functions whose arguments have
// changed their type from v4f32 to v2i64.
//<editor-fold defaultstate="collapsed" desc="UpgradeSSE41Function">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 36,
 FQN="UpgradeSSE41Function", NM="_ZL20UpgradeSSE41FunctionPN4llvm8FunctionENS_9Intrinsic2IDERS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZL20UpgradeSSE41FunctionPN4llvm8FunctionENS_9Intrinsic2IDERS1_")
//</editor-fold>
public static boolean UpgradeSSE41Function(Function /*P*/ F, /*Intrinsic.ID*/int IID, 
                    final type$ref<Function /*P*/ /*&*/> NewFn) {
  // Check whether this is an old version of the function, which received
  // v4f32 arguments.
  Type /*P*/ Arg0Type = F.getFunctionType().getParamType(0);
  if (Arg0Type != VectorType.get(Type.getFloatTy(F.getContext()), 4)) {
    return false;
  }
  
  // Yes, it's old, replace it with new version.
  F.setName($add_StringRef$C_char$ptr$C(F.getName(), /*KEEP_STR*/".old"));
  NewFn.$set(getDeclaration(F.getParent(), IID));
  return true;
}


// Upgrade the declarations of intrinsic functions whose 8-bit immediate mask
// arguments have changed their type from i32 to i8.
//<editor-fold defaultstate="collapsed" desc="UpgradeX86IntrinsicsWith8BitMask">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 52,
 FQN="UpgradeX86IntrinsicsWith8BitMask", NM="_ZL32UpgradeX86IntrinsicsWith8BitMaskPN4llvm8FunctionENS_9Intrinsic2IDERS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZL32UpgradeX86IntrinsicsWith8BitMaskPN4llvm8FunctionENS_9Intrinsic2IDERS1_")
//</editor-fold>
public static boolean UpgradeX86IntrinsicsWith8BitMask(Function /*P*/ F, /*Intrinsic.ID*/int IID, 
                                final type$ref<Function /*P*/ /*&*/> NewFn) {
  // Check that the last argument is an i32.
  Type /*P*/ LastArgType = F.getFunctionType().getParamType(F.getFunctionType().getNumParams() - 1);
  if (!LastArgType.isIntegerTy(32)) {
    return false;
  }
  
  // Move this function aside and map down.
  F.setName($add_StringRef$C_char$ptr$C(F.getName(), /*KEEP_STR*/".old"));
  NewFn.$set(getDeclaration(F.getParent(), IID));
  return true;
}

//<editor-fold defaultstate="collapsed" desc="UpgradeIntrinsicFunction1">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 66,
 FQN="UpgradeIntrinsicFunction1", NM="_ZL25UpgradeIntrinsicFunction1PN4llvm8FunctionERS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZL25UpgradeIntrinsicFunction1PN4llvm8FunctionERS1_")
//</editor-fold>
public static boolean UpgradeIntrinsicFunction1(Function /*P*/ F, final type$ref<Function /*P*/ /*&*/> NewFn) {
  assert ((F != null)) : "Illegal to upgrade a non-existent Function.";
  
  // Quickly eliminate it, if it's not a candidate.
  StringRef Name = F.getName();
  if ($lesseq_uint(Name.size(), 8) || !Name.startswith(/*STRINGREF_STR*/"llvm.")) {
    return false;
  }
  Name.$assignMove(Name.substr(5)); // Strip off "llvm."
  switch (Name.$at(0)) {
   default:
    break;
   case 'a':
    {
      Regex vldRegex = null;
      Regex vstRegex = null;
      try {
        if (Name.startswith(/*STRINGREF_STR*/"arm.neon.vclz")) {
          Type /*P*/ args[/*2*/] = new Type /*P*/  [/*2*/] {
            F.arg_begin().$arrow().getType(), 
            Type.getInt1Ty(F.getContext())
          };
          // Can't use Intrinsic::getDeclaration here as it adds a ".i1" to
          // the end of the name. Change name from llvm.arm.neon.vclz.* to
          //  llvm.ctlz.*
          FunctionType /*P*/ fType = FunctionType.get(F.getReturnType(), new ArrayRef<Type /*P*/ >(/*2,*/ args, true), false);
          NewFn.$set(Function.Create(fType, F.getLinkage(), 
              $add_char$ptr$C_StringRef$C(/*KEEP_STR*/"llvm.ctlz.", Name.substr(14)), F.getParent()));
          return true;
        }
        if (Name.startswith(/*STRINGREF_STR*/"arm.neon.vcnt")) {
          NewFn.$set(getDeclaration(F.getParent(), ID.ctpop, 
              new ArrayRef<Type /*P*/ >(F.arg_begin().$arrow().getType(), true)));
          return true;
        }
        vldRegex/*J*/= new Regex(new StringRef(/*KEEP_STR*/"^arm\\.neon\\.vld([1234]|[234]lane)\\.v[a-z0-9]*$"));
        if (vldRegex.match(/*NO_COPY*/Name)) {
          ArrayRef<Type /*P*/ > fArgs = F.getFunctionType().params();
          SmallVector<Type /*P*/ > Tys/*J*/= new SmallVector<Type /*P*/ >(JD$T.INSTANCE, 4, fArgs.begin(), fArgs.end(), (Type /*P*/ )null);
          // Can't use Intrinsic::getDeclaration here as the return types might
          // then only be structurally equal.
          FunctionType /*P*/ fType = FunctionType.get(F.getReturnType(), new ArrayRef<Type /*P*/ >(Tys, true), false);
          NewFn.$set(Function.Create(fType, F.getLinkage(), 
              $add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"llvm.", Name), new Twine(/*KEEP_STR*/".p0i8")), F.getParent()));
          return true;
        }
        vstRegex/*J*/= new Regex(new StringRef(/*KEEP_STR*/"^arm\\.neon\\.vst([1234]|[234]lane)\\.v[a-z0-9]*$"));
        if (vstRegex.match(/*NO_COPY*/Name)) {
          final/*static*/ /*const*/ int StoreInts[/*4*/] = UpgradeIntrinsicFunction1$$.StoreInts;
          
          final/*static*/ /*const*/ int StoreLaneInts[/*3*/] = UpgradeIntrinsicFunction1$$.StoreLaneInts;
          
          ArrayRef<Type /*P*/ > fArgs = F.getFunctionType().params();
          Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {fArgs.$at(0), fArgs.$at(1)};
          if (Name.find(/*STRINGREF_STR*/"lane") == StringRef.npos) {
            NewFn.$set(getDeclaration(F.getParent(), 
                StoreInts[fArgs.size() - 3], new ArrayRef<Type /*P*/ >(/*2,*/ Tys, true)));
          } else {
            NewFn.$set(getDeclaration(F.getParent(), 
                StoreLaneInts[fArgs.size() - 5], new ArrayRef<Type /*P*/ >(/*2,*/ Tys, true)));
          }
          return true;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"aarch64.thread.pointer") || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"arm.thread.pointer")) {
          NewFn.$set(getDeclaration(F.getParent(), ID.thread_pointer));
          return true;
        }
        break;
      } finally {
        if (vstRegex != null) { vstRegex.$destroy(); }
        if (vldRegex != null) { vldRegex.$destroy(); }
      }
    }
   case 'c':
    {
      if (Name.startswith(/*STRINGREF_STR*/"ctlz.") && F.arg_size() == 1) {
        F.setName($add_StringRef$C_char$ptr$C(Name, /*KEEP_STR*/".old"));
        NewFn.$set(getDeclaration(F.getParent(), ID.ctlz, 
            new ArrayRef<Type /*P*/ >(F.arg_begin().$arrow().getType(), true)));
        return true;
      }
      if (Name.startswith(/*STRINGREF_STR*/"cttz.") && F.arg_size() == 1) {
        F.setName($add_StringRef$C_char$ptr$C(Name, /*KEEP_STR*/".old"));
        NewFn.$set(getDeclaration(F.getParent(), ID.cttz, 
            new ArrayRef<Type /*P*/ >(F.arg_begin().$arrow().getType(), true)));
        return true;
      }
      break;
    }
   case 'm':
    {
      if (Name.startswith(/*STRINGREF_STR*/"masked.load.")) {
        Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {F.getReturnType(), F.arg_begin().$arrow().getType()};
        if ($noteq_StringRef(F.getName(), new StringRef(getName(ID.masked_load, new ArrayRef<Type /*P*/ >(/*2,*/ Tys, true))))) {
          F.setName($add_StringRef$C_char$ptr$C(Name, /*KEEP_STR*/".old"));
          NewFn.$set(getDeclaration(F.getParent(), 
              ID.masked_load, 
              new ArrayRef<Type /*P*/ >(/*2,*/ Tys, true)));
          return true;
        }
      }
      if (Name.startswith(/*STRINGREF_STR*/"masked.store.")) {
        ArrayRef<Type /*P*/ > Args = F.getFunctionType().params();
        Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Args.$at(0), Args.$at(1)};
        if ($noteq_StringRef(F.getName(), new StringRef(getName(ID.masked_store, new ArrayRef<Type /*P*/ >(/*2,*/ Tys, true))))) {
          F.setName($add_StringRef$C_char$ptr$C(Name, /*KEEP_STR*/".old"));
          NewFn.$set(getDeclaration(F.getParent(), 
              ID.masked_store, 
              new ArrayRef<Type /*P*/ >(/*2,*/ Tys, true)));
          return true;
        }
      }
      break;
    }
   case 'o':
    // We only need to change the name to match the mangling including the
    // address space.
    if (F.arg_size() == 2 && Name.startswith(/*STRINGREF_STR*/"objectsize.")) {
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {F.getReturnType(), F.arg_begin().$arrow().getType()};
      if ($noteq_StringRef(F.getName(), new StringRef(getName(ID.objectsize, new ArrayRef<Type /*P*/ >(/*2,*/ Tys, true))))) {
        F.setName($add_StringRef$C_char$ptr$C(Name, /*KEEP_STR*/".old"));
        NewFn.$set(getDeclaration(F.getParent(), 
            ID.objectsize, new ArrayRef<Type /*P*/ >(/*2,*/ Tys, true)));
        return true;
      }
    }
    break;
   case 's':
    if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"stackprotectorcheck")) {
      NewFn.$set(null);
      return true;
    }
   case 'x':
    {
      boolean IsX86 = Name.startswith(/*STRINGREF_STR*/"x86.");
      if (IsX86) {
        Name.$assignMove(Name.substr(4));
      }
      if (IsX86
         && (Name.startswith(/*STRINGREF_STR*/"sse2.pcmpeq.")
         || Name.startswith(/*STRINGREF_STR*/"sse2.pcmpgt.")
         || Name.startswith(/*STRINGREF_STR*/"avx2.pcmpeq.")
         || Name.startswith(/*STRINGREF_STR*/"avx2.pcmpgt.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.pcmpeq.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.pcmpgt.")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.pmaxsb")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.pmaxs.w")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.pmaxsd")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.pmaxu.b")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.pmaxuw")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.pmaxud")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.pminsb")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.pmins.w")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.pminsd")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.pminu.b")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.pminuw")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.pminud")
         || Name.startswith(/*STRINGREF_STR*/"avx2.pmax")
         || Name.startswith(/*STRINGREF_STR*/"avx2.pmin")
         || Name.startswith(/*STRINGREF_STR*/"avx2.vbroadcast")
         || Name.startswith(/*STRINGREF_STR*/"avx2.pbroadcast")
         || Name.startswith(/*STRINGREF_STR*/"avx.vpermil.")
         || Name.startswith(/*STRINGREF_STR*/"sse2.pshuf")
         || Name.startswith(/*STRINGREF_STR*/"avx512.pbroadcast")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.broadcast.s")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.movddup")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.movshdup")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.movsldup")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.pshuf.d.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.pshufl.w.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.pshufh.w.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.vpermil.p")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.perm.df.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.perm.di.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.punpckl")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.punpckh")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.unpckl.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.unpckh.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.pand.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.pandn.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.por.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.pxor.")
         || Name.startswith(/*STRINGREF_STR*/"sse41.pmovsx")
         || Name.startswith(/*STRINGREF_STR*/"sse41.pmovzx")
         || Name.startswith(/*STRINGREF_STR*/"avx2.pmovsx")
         || Name.startswith(/*STRINGREF_STR*/"avx2.pmovzx")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.cvtdq2pd")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.cvtps2pd")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx.cvtdq2.pd.256")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx.cvt.ps2.pd.256")
         || Name.startswith(/*STRINGREF_STR*/"avx.vinsertf128.")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx2.vinserti128")
         || Name.startswith(/*STRINGREF_STR*/"avx.vextractf128.")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx2.vextracti128")
         || Name.startswith(/*STRINGREF_STR*/"sse4a.movnt.")
         || Name.startswith(/*STRINGREF_STR*/"avx.movnt.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.storent.")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.storel.dq")
         || Name.startswith(/*STRINGREF_STR*/"sse.storeu.")
         || Name.startswith(/*STRINGREF_STR*/"sse2.storeu.")
         || Name.startswith(/*STRINGREF_STR*/"avx.storeu.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.storeu.p")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.storeu.b.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.storeu.w.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.storeu.d.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.storeu.q.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.store.p")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.store.b.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.store.w.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.store.d.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.store.q.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.loadu.p")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.loadu.b.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.loadu.w.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.loadu.d.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.loadu.q.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.load.p")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.load.b.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.load.w.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.load.d.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.load.q.")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse42.crc32.64.8")
         || Name.startswith(/*STRINGREF_STR*/"avx.vbroadcast.s")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.palignr.")
         || Name.startswith(/*STRINGREF_STR*/"sse2.psll.dq")
         || Name.startswith(/*STRINGREF_STR*/"sse2.psrl.dq")
         || Name.startswith(/*STRINGREF_STR*/"avx2.psll.dq")
         || Name.startswith(/*STRINGREF_STR*/"avx2.psrl.dq")
         || Name.startswith(/*STRINGREF_STR*/"avx512.psll.dq")
         || Name.startswith(/*STRINGREF_STR*/"avx512.psrl.dq")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.pblendw")
         || Name.startswith(/*STRINGREF_STR*/"sse41.blendp")
         || Name.startswith(/*STRINGREF_STR*/"avx.blend.p")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx2.pblendw")
         || Name.startswith(/*STRINGREF_STR*/"avx2.pblendd.")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx2.vbroadcasti128")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"xop.vpcmov")
         || (Name.startswith(/*STRINGREF_STR*/"xop.vpcom") && F.arg_size() == 2))) {
        NewFn.$set(null);
        return true;
      }
      // SSE4.1 ptest functions may have an old signature.
      if (IsX86 && Name.startswith(/*STRINGREF_STR*/"sse41.ptest")) {
        if ($eq_StringRef(Name.substr(11), /*STRINGREF_STR*/"c")) {
          return UpgradeSSE41Function(F, ID.x86_sse41_ptestc, NewFn);
        }
        if ($eq_StringRef(Name.substr(11), /*STRINGREF_STR*/"z")) {
          return UpgradeSSE41Function(F, ID.x86_sse41_ptestz, NewFn);
        }
        if ($eq_StringRef(Name.substr(11), /*STRINGREF_STR*/"nzc")) {
          return UpgradeSSE41Function(F, ID.x86_sse41_ptestnzc, NewFn);
        }
      }
      // Several blend and other instructions with masks used the wrong number of
      // bits.
      if (IsX86 && $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.insertps")) {
        return UpgradeX86IntrinsicsWith8BitMask(F, ID.x86_sse41_insertps, 
            NewFn);
      }
      if (IsX86 && $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.dppd")) {
        return UpgradeX86IntrinsicsWith8BitMask(F, ID.x86_sse41_dppd, 
            NewFn);
      }
      if (IsX86 && $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.dpps")) {
        return UpgradeX86IntrinsicsWith8BitMask(F, ID.x86_sse41_dpps, 
            NewFn);
      }
      if (IsX86 && $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.mpsadbw")) {
        return UpgradeX86IntrinsicsWith8BitMask(F, ID.x86_sse41_mpsadbw, 
            NewFn);
      }
      if (IsX86 && $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx.dp.ps.256")) {
        return UpgradeX86IntrinsicsWith8BitMask(F, ID.x86_avx_dp_ps_256, 
            NewFn);
      }
      if (IsX86 && $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx2.mpsadbw")) {
        return UpgradeX86IntrinsicsWith8BitMask(F, ID.x86_avx2_mpsadbw, 
            NewFn);
      }
      
      // frcz.ss/sd may need to have an argument dropped
      if (IsX86 && Name.startswith(/*STRINGREF_STR*/"xop.vfrcz.ss") && F.arg_size() == 2) {
        F.setName($add_StringRef$C_char$ptr$C(Name, /*KEEP_STR*/".old"));
        NewFn.$set(getDeclaration(F.getParent(), 
            ID.x86_xop_vfrcz_ss));
        return true;
      }
      if (IsX86 && Name.startswith(/*STRINGREF_STR*/"xop.vfrcz.sd") && F.arg_size() == 2) {
        F.setName($add_StringRef$C_char$ptr$C(Name, /*KEEP_STR*/".old"));
        NewFn.$set(getDeclaration(F.getParent(), 
            ID.x86_xop_vfrcz_sd));
        return true;
      }
      if (IsX86 && (Name.startswith(/*STRINGREF_STR*/"avx512.mask.pslli.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.psrai.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.psrli."))) {
        /*Intrinsic.ID*/int ShiftID;
        if ($eq_StringRef(Name.slice(12, 16), /*STRINGREF_STR*/"psll")) {
          ShiftID = Name.$at(18) == $$d ? ID.x86_avx512_mask_psll_di_512 : ID.x86_avx512_mask_psll_qi_512;
        } else if ($eq_StringRef(Name.slice(12, 16), /*STRINGREF_STR*/"psra")) {
          ShiftID = Name.$at(18) == $$d ? ID.x86_avx512_mask_psra_di_512 : ID.x86_avx512_mask_psra_qi_512;
        } else {
          ShiftID = Name.$at(18) == $$d ? ID.x86_avx512_mask_psrl_di_512 : ID.x86_avx512_mask_psrl_qi_512;
        }
        F.setName($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"llvm.x86.", Name), new Twine(/*KEEP_STR*/".old")));
        NewFn.$set(getDeclaration(F.getParent(), ShiftID));
        return true;
      }
      // Fix the FMA4 intrinsics to remove the 4
      if (IsX86 && Name.startswith(/*STRINGREF_STR*/"fma4.")) {
        F.setName($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"llvm.x86.fma", Name.substr(5)));
        NewFn.$set(F);
        return true;
      }
      // Upgrade any XOP PERMIL2 index operand still using a float/double vector.
      if (IsX86 && Name.startswith(/*STRINGREF_STR*/"xop.vpermil2")) {
        ArrayRef<Type /*P*/ > Params = F.getFunctionType().params();
        Type /*P*/ Idx = Params.$at(2);
        if (Idx.getScalarType().isFloatingPointTy()) {
          F.setName($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"llvm.x86.", Name), new Twine(/*KEEP_STR*/".old")));
          /*uint*/int IdxSize = Idx.getPrimitiveSizeInBits();
          /*uint*/int EltSize = Idx.getScalarSizeInBits();
          /*Intrinsic.ID*/int Permil2ID;
          if (EltSize == 64 && IdxSize == 128) {
            Permil2ID = ID.x86_xop_vpermil2pd;
          } else if (EltSize == 32 && IdxSize == 128) {
            Permil2ID = ID.x86_xop_vpermil2ps;
          } else if (EltSize == 64 && IdxSize == 256) {
            Permil2ID = ID.x86_xop_vpermil2pd_256;
          } else {
            Permil2ID = ID.x86_xop_vpermil2ps_256;
          }
          NewFn.$set(getDeclaration(F.getParent(), Permil2ID));
          return true;
        }
      }
      break;
    }
  }
  
  //  This may not belong here. This function is effectively being overloaded
  //  to both detect an intrinsic which needs upgrading, and to provide the
  //  upgraded form of the intrinsic. We should perhaps have two separate
  //  functions for this.
  return false;
}
private static final class UpgradeIntrinsicFunction1$$ {
  static final/*static*/ /*const*/ int StoreInts[/*4*/] = new /*Intrinsic.ID*/int [/*4*/] {
    ID.arm_neon_vst1, 
    ID.arm_neon_vst2, 
    ID.arm_neon_vst3, 
    ID.arm_neon_vst4};
  static final/*static*/ /*const*/ int StoreLaneInts[/*3*/] = new /*Intrinsic.ID*/int [/*3*/] {
    ID.arm_neon_vst2lane, ID.arm_neon_vst3lane, 
    ID.arm_neon_vst4lane
  };
}


// Handles upgrading SSE2/AVX2/AVX512BW PSLLDQ intrinsics by converting them
// to byte shuffles.
//<editor-fold defaultstate="collapsed" desc="UpgradeX86PSLLDQIntrinsics">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 423,
 FQN="UpgradeX86PSLLDQIntrinsics", NM="_ZL26UpgradeX86PSLLDQIntrinsicsRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZL26UpgradeX86PSLLDQIntrinsicsRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueEj")
//</editor-fold>
public static Value /*P*/ UpgradeX86PSLLDQIntrinsics(final IRBuilder /*&*/ Builder, 
                          Value /*P*/ Op, /*uint*/int Shift) {
  Type /*P*/ ResultTy = Op.getType();
  /*uint*/int NumElts = ResultTy.getVectorNumElements() * 8;
  
  // Bitcast from a 64-bit element type to a byte element type.
  Type /*P*/ VecTy = VectorType.get(Builder.getInt8Ty(), NumElts);
  Op = Builder.CreateBitCast(Op, VecTy, new Twine(/*KEEP_STR*/"cast"));
  
  // We'll be shuffling in zeroes.
  Value /*P*/ Res = Constant.getNullValue(VecTy);
  
  // If shift is less than 16, emit a shuffle to move the bytes. Otherwise,
  // we'll just return the zero vector.
  if ($less_uint(Shift, 16)) {
    /*uint32_t*/int Idxs[/*64*/] = new$uint(64);
    // 256/512-bit version is split into 2/4 16-byte lanes.
    for (/*uint*/int l = 0; l != NumElts; l += 16)  {
      for (/*uint*/int i = 0; i != 16; ++i) {
        /*uint*/int Idx = NumElts + i - Shift;
        if ($less_uint(Idx, NumElts)) {
          Idx -= NumElts - 16; // end of lane, switch operand.
        }
        Idxs[l + i] = Idx + l;
      }
    }
    
    Res = Builder.CreateShuffleVector(Res, Op, makeArrayRef/*$UInt*/(Idxs, NumElts));
  }
  
  // Bitcast back to a 64-bit element type.
  return Builder.CreateBitCast(Res, ResultTy, new Twine(/*KEEP_STR*/"cast"));
}


// Handles upgrading SSE2/AVX2/AVX512BW PSRLDQ intrinsics by converting them
// to byte shuffles.
//<editor-fold defaultstate="collapsed" desc="UpgradeX86PSRLDQIntrinsics">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 457,
 FQN="UpgradeX86PSRLDQIntrinsics", NM="_ZL26UpgradeX86PSRLDQIntrinsicsRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZL26UpgradeX86PSRLDQIntrinsicsRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueEj")
//</editor-fold>
public static Value /*P*/ UpgradeX86PSRLDQIntrinsics(final IRBuilder /*&*/ Builder, Value /*P*/ Op, 
                          /*uint*/int Shift) {
  Type /*P*/ ResultTy = Op.getType();
  /*uint*/int NumElts = ResultTy.getVectorNumElements() * 8;
  
  // Bitcast from a 64-bit element type to a byte element type.
  Type /*P*/ VecTy = VectorType.get(Builder.getInt8Ty(), NumElts);
  Op = Builder.CreateBitCast(Op, VecTy, new Twine(/*KEEP_STR*/"cast"));
  
  // We'll be shuffling in zeroes.
  Value /*P*/ Res = Constant.getNullValue(VecTy);
  
  // If shift is less than 16, emit a shuffle to move the bytes. Otherwise,
  // we'll just return the zero vector.
  if ($less_uint(Shift, 16)) {
    /*uint32_t*/int Idxs[/*64*/] = new$uint(64);
    // 256/512-bit version is split into 2/4 16-byte lanes.
    for (/*uint*/int l = 0; l != NumElts; l += 16)  {
      for (/*uint*/int i = 0; i != 16; ++i) {
        /*uint*/int Idx = i + Shift;
        if ($greatereq_uint(Idx, 16)) {
          Idx += NumElts - 16; // end of lane, switch operand.
        }
        Idxs[l + i] = Idx + l;
      }
    }
    
    Res = Builder.CreateShuffleVector(Op, Res, makeArrayRef/*$UInt*/(Idxs, NumElts));
  }
  
  // Bitcast back to a 64-bit element type.
  return Builder.CreateBitCast(Res, ResultTy, new Twine(/*KEEP_STR*/"cast"));
}

//<editor-fold defaultstate="collapsed" desc="getX86MaskVec">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 489,
 FQN="getX86MaskVec", NM="_ZL13getX86MaskVecRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZL13getX86MaskVecRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueEj")
//</editor-fold>
public static Value /*P*/ getX86MaskVec(final IRBuilder /*&*/ Builder, Value /*P*/ Mask, 
             /*uint*/int NumElts) {
  VectorType /*P*/ MaskTy = VectorType.get(Builder.getInt1Ty(), 
      cast_IntegerType(Mask.getType()).getBitWidth());
  Mask = Builder.CreateBitCast(Mask, MaskTy);
  
  // If we have less than 8 elements, then the starting mask was an i8 and
  // we need to extract down to the right number of elements.
  if ($less_uint(NumElts, 8)) {
    /*uint32_t*/int Indices[/*4*/] = new$uint(4);
    for (/*uint*/int i = 0; i != NumElts; ++i)  {
      Indices[i] = i;
    }
    Mask = Builder.CreateShuffleVector(Mask, Mask, 
        makeArrayRef(Indices, NumElts), 
        new Twine(/*KEEP_STR*/"extract"));
  }
  
  return Mask;
}

//<editor-fold defaultstate="collapsed" desc="EmitX86Select">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 509,
 FQN="EmitX86Select", NM="_ZL13EmitX86SelectRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueES6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZL13EmitX86SelectRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueES6_S6_")
//</editor-fold>
public static Value /*P*/ EmitX86Select(final IRBuilder /*&*/ Builder, Value /*P*/ Mask, 
             Value /*P*/ Op0, Value /*P*/ Op1) {
  {
    // If the mask is all ones just emit the align operation.
    /*const*/ Constant /*P*/ C = dyn_cast_Constant(Mask);
    if ((C != null)) {
      if (C.isAllOnesValue()) {
        return Op0;
      }
    }
  }
  
  Mask = getX86MaskVec(Builder, Mask, Op0.getType().getVectorNumElements());
  return Builder.CreateSelect(Mask, Op0, Op1);
}

//<editor-fold defaultstate="collapsed" desc="UpgradeX86PALIGNRIntrinsics">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 520,
 FQN="UpgradeX86PALIGNRIntrinsics", NM="_ZL27UpgradeX86PALIGNRIntrinsicsRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueES6_S6_S6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZL27UpgradeX86PALIGNRIntrinsicsRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueES6_S6_S6_S6_")
//</editor-fold>
public static Value /*P*/ UpgradeX86PALIGNRIntrinsics(final IRBuilder /*&*/ Builder, 
                           Value /*P*/ Op0, Value /*P*/ Op1, Value /*P*/ Shift, 
                           Value /*P*/ Passthru, Value /*P*/ Mask) {
  /*uint*/int ShiftVal = $ulong2uint(cast_ConstantInt(Shift).getZExtValue());
  
  /*uint*/int NumElts = Op0.getType().getVectorNumElements();
  assert ($rem_uint(NumElts, 16) == 0);
  
  // If palignr is shifting the pair of vectors more than the size of two
  // lanes, emit zero.
  if ($greatereq_uint(ShiftVal, 32)) {
    return Constant.getNullValue(Op0.getType());
  }
  
  // If palignr is shifting the pair of input vectors more than one lane,
  // but less than two lanes, convert to shifting in zeroes.
  if ($greater_uint(ShiftVal, 16)) {
    ShiftVal -= 16;
    Op1 = Op0;
    Op0 = Constant.getNullValue(Op0.getType());
  }
  
  /*uint32_t*/int Indices[/*64*/] = new$uint(64);
  // 256-bit palignr operates on 128-bit lanes so we need to handle that
  for (/*uint*/int l = 0; l != NumElts; l += 16) {
    for (/*uint*/int i = 0; i != 16; ++i) {
      /*uint*/int Idx = ShiftVal + i;
      if ($greatereq_uint(Idx, 16)) {
        Idx += NumElts - 16; // End of lane, switch operand.
      }
      Indices[l + i] = Idx + l;
    }
  }
  
  Value /*P*/ Align = Builder.CreateShuffleVector(Op1, Op0, 
      makeArrayRef/*$UInt*/(Indices, NumElts), 
      new Twine(/*KEEP_STR*/"palignr"));
  
  return EmitX86Select(Builder, Mask, Align, Passthru);
}

//<editor-fold defaultstate="collapsed" desc="UpgradeMaskedStore">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 559,
 FQN="UpgradeMaskedStore", NM="_ZL18UpgradeMaskedStoreRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueES6_S6_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZL18UpgradeMaskedStoreRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueES6_S6_b")
//</editor-fold>
public static Value /*P*/ UpgradeMaskedStore(final IRBuilder /*&*/ Builder, 
                  Value /*P*/ Ptr, Value /*P*/ Data, Value /*P*/ Mask, 
                  boolean Aligned) {
  // Cast the pointer to the right type.
  Ptr = Builder.CreateBitCast(Ptr, 
      PointerType.getUnqual(Data.getType()));
  /*uint*/int Align = Aligned ? $div_uint(cast_VectorType(Data.getType()).getBitWidth(), 8) : 1;
  {
    
    // If the mask is all ones just emit a regular store.
    /*const*/ Constant /*P*/ C = dyn_cast_Constant(Mask);
    if ((C != null)) {
      if (C.isAllOnesValue()) {
        return Builder.CreateAlignedStore(Data, Ptr, Align);
      }
    }
  }
  
  // Convert the mask from an integer type to a vector of i1.
  /*uint*/int NumElts = Data.getType().getVectorNumElements();
  Mask = getX86MaskVec(Builder, Mask, NumElts);
  return Builder.CreateMaskedStore(Data, Ptr, Align, Mask);
}

//<editor-fold defaultstate="collapsed" desc="UpgradeMaskedLoad">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 579,
 FQN="UpgradeMaskedLoad", NM="_ZL17UpgradeMaskedLoadRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueES6_S6_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZL17UpgradeMaskedLoadRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPNS_5ValueES6_S6_b")
//</editor-fold>
public static Value /*P*/ UpgradeMaskedLoad(final IRBuilder /*&*/ Builder, 
                 Value /*P*/ Ptr, Value /*P*/ Passthru, Value /*P*/ Mask, 
                 boolean Aligned) {
  // Cast the pointer to the right type.
  Ptr = Builder.CreateBitCast(Ptr, 
      PointerType.getUnqual(Passthru.getType()));
  /*uint*/int Align = Aligned ? $div_uint(cast_VectorType(Passthru.getType()).getBitWidth(), 8) : 1;
  {
    
    // If the mask is all ones just emit a regular store.
    /*const*/ Constant /*P*/ C = dyn_cast_Constant(Mask);
    if ((C != null)) {
      if (C.isAllOnesValue()) {
        return Builder.CreateAlignedLoad(Ptr, Align);
      }
    }
  }
  
  // Convert the mask from an integer type to a vector of i1.
  /*uint*/int NumElts = Passthru.getType().getVectorNumElements();
  Mask = getX86MaskVec(Builder, Mask, NumElts);
  return Builder.CreateMaskedLoad(Ptr, Align, Mask, Passthru);
}

//<editor-fold defaultstate="collapsed" desc="upgradeIntMinMax">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 599,
 FQN="upgradeIntMinMax", NM="_ZL16upgradeIntMinMaxRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERNS_8CallInstENS_7CmpInst9PredicateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZL16upgradeIntMinMaxRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERNS_8CallInstENS_7CmpInst9PredicateE")
//</editor-fold>
public static Value /*P*/ upgradeIntMinMax(final IRBuilder /*&*/ Builder, final CallInst /*&*/ CI, 
                ICmpInst.Predicate Pred) {
  Value /*P*/ Op0 = CI.getArgOperand(0);
  Value /*P*/ Op1 = CI.getArgOperand(1);
  Value /*P*/ Cmp = Builder.CreateICmp(Pred, Op0, Op1);
  return Builder.CreateSelect(Cmp, Op0, Op1);
}

//<editor-fold defaultstate="collapsed" desc="upgradeMaskedCompare">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 607,
 FQN="upgradeMaskedCompare", NM="_ZL20upgradeMaskedCompareRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERNS_8CallInstENS_7CmpInst9PredicateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZL20upgradeMaskedCompareRN4llvm9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERNS_8CallInstENS_7CmpInst9PredicateE")
//</editor-fold>
public static Value /*P*/ upgradeMaskedCompare(final IRBuilder /*&*/ Builder, final CallInst /*&*/ CI, 
                    ICmpInst.Predicate Pred) {
  Value /*P*/ Op0 = CI.getArgOperand(0);
  /*uint*/int NumElts = Op0.getType().getVectorNumElements();
  Value /*P*/ Cmp = Builder.CreateICmp(Pred, Op0, CI.getArgOperand(1));
  
  Value /*P*/ Mask = CI.getArgOperand(2);
  /*const*/ Constant /*P*/ C = dyn_cast_Constant(Mask);
  if (!(C != null) || !C.isAllOnesValue()) {
    Cmp = Builder.CreateAnd(Cmp, getX86MaskVec(Builder, Mask, NumElts));
  }
  if ($less_uint(NumElts, 8)) {
    /*uint32_t*/int Indices[/*8*/] = new$uint(8);
    for (/*uint*/int i = 0; i != NumElts; ++i)  {
      Indices[i] = i;
    }
    for (/*uint*/int i = NumElts; i != 8; ++i)  {
      Indices[i] = NumElts + $rem_uint(i, NumElts);
    }
    Cmp = Builder.CreateShuffleVector(Cmp, 
        Constant.getNullValue(Cmp.getType()), 
        new ArrayRefUInt(/*8, */Indices));
  }
  return Builder.CreateBitCast(Cmp, IntegerType.get(CI.getContext(), 
          std.max(NumElts, 8/*U*/)));
}

//<editor-fold defaultstate="collapsed" desc="isOldLoopArgument">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 1476,
 FQN="isOldLoopArgument", NM="_ZL17isOldLoopArgumentPN4llvm8MetadataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZL17isOldLoopArgumentPN4llvm8MetadataE")
//</editor-fold>
public static boolean isOldLoopArgument(Metadata /*P*/ MD) {
  MDTuple /*P*/ T = dyn_cast_or_null_MDTuple(MD);
  if (!(T != null)) {
    return false;
  }
  if ($less_uint(T.getNumOperands(), 1)) {
    return false;
  }
  MDString /*P*/ S = IRManualRTTI.dyn_cast_or_null_MDString(T.getOperand(0));
  if (!(S != null)) {
    return false;
  }
  return S.getString().startswith(/*STRINGREF_STR*/"llvm.vectorizer.");
}

//<editor-fold defaultstate="collapsed" desc="upgradeLoopTag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 1488,
 FQN="upgradeLoopTag", NM="_ZL14upgradeLoopTagRN4llvm11LLVMContextENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZL14upgradeLoopTagRN4llvm11LLVMContextENS_9StringRefE")
//</editor-fold>
public static MDString /*P*/ upgradeLoopTag(final LLVMContext /*&*/ C, StringRef OldTag) {
  StringRef OldPrefix = new StringRef(/*KEEP_STR*/"llvm.vectorizer.");
  assert (OldTag.startswith(/*NO_COPY*/OldPrefix)) : "Expected old prefix";
  if ($eq_StringRef(/*NO_COPY*/OldTag, /*STRINGREF_STR*/"llvm.vectorizer.unroll")) {
    return MDString.get(C, $("llvm.loop.interleave.count"));
  }
  
  return MDString.get(C, new StringRef(($add_Twine$C(new Twine(/*KEEP_STR*/"llvm.loop.vectorize."), new Twine(OldTag.drop_front(OldPrefix.size())))).
              str()));
}

//<editor-fold defaultstate="collapsed" desc="upgradeLoopArgument">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 1500,
 FQN="upgradeLoopArgument", NM="_ZL19upgradeLoopArgumentPN4llvm8MetadataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZL19upgradeLoopArgumentPN4llvm8MetadataE")
//</editor-fold>
public static Metadata /*P*/ upgradeLoopArgument(Metadata /*P*/ MD) {
  MDTuple /*P*/ T = dyn_cast_or_null_MDTuple(MD);
  if (!(T != null)) {
    return MD;
  }
  if ($less_uint(T.getNumOperands(), 1)) {
    return MD;
  }
  MDString /*P*/ OldTag = IRManualRTTI.dyn_cast_or_null_MDString(T.getOperand(0));
  if (!(OldTag != null)) {
    return MD;
  }
  if (!OldTag.getString().startswith(/*STRINGREF_STR*/"llvm.vectorizer.")) {
    return MD;
  }
  
  // This has an old tag.  Upgrade it.
  SmallVector<Metadata /*P*/ > Ops/*J*/= new SmallVector<Metadata /*P*/ >(8, (Metadata /*P*/ )null);
  Ops.reserve(T.getNumOperands());
  Ops.push_back(upgradeLoopTag(T.getContext(), OldTag.getString()));
  for (/*uint*/int I = 1, E = T.getNumOperands(); I != E; ++I)  {
    Ops.push_back(T.getOperand(I).$Metadata$P());
  }
  
  return MDTuple.get(T.getContext(), new ArrayRef<Metadata /*P*/ >(Ops, true));
}

} // END OF class AutoUpgradeStatics

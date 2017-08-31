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
package org.clang.staticanalyzer.core.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerFunctionPointers.*;


//<editor-fold defaultstate="collapsed" desc="static type CheckerRegistryStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp -nm=_ZL11isInPackageRKN5clang4ento15CheckerRegistry11CheckerInfoEN4llvm9StringRefE;_ZL13checkerNameLTRKN5clang4ento15CheckerRegistry11CheckerInfoES4_;_ZL15collectCheckersRKSt6vectorIN5clang4ento15CheckerRegistry11CheckerInfoESaIS3_EERKN4llvm9StringMapIjNS8_15MallocAllocatorEEERNS1_14CheckerOptInfoERNS8_9SetVectorIPKS3_S_ISI_SaISI_EENS8_8DenseSetISI_NS8_12DenseMapInfoISI_EEEEEE;_ZL16PackageSeparator; -static-type=CheckerRegistryStatics -package=org.clang.staticanalyzer.core.impl")
//</editor-fold>
public final class CheckerRegistryStatics {

//<editor-fold defaultstate="collapsed" desc="PackageSeparator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp", line = 21,
 FQN="PackageSeparator", NM="_ZL16PackageSeparator",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp -nm=_ZL16PackageSeparator")
//</editor-fold>
public static /*const*//*char*/byte PackageSeparator = $$DOT;
//<editor-fold defaultstate="collapsed" desc="checkerNameLT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp", line = 25,
 FQN="checkerNameLT", NM="_ZL13checkerNameLTRKN5clang4ento15CheckerRegistry11CheckerInfoES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp -nm=_ZL13checkerNameLTRKN5clang4ento15CheckerRegistry11CheckerInfoES4_")
//</editor-fold>
public static boolean checkerNameLT(final /*const*/ CheckerRegistry.CheckerInfo /*&*/ a, 
             final /*const*/ CheckerRegistry.CheckerInfo /*&*/ b) {
  return $less_StringRef(/*NO_COPY*/a.FullName, /*NO_COPY*/b.FullName);
}

//<editor-fold defaultstate="collapsed" desc="isInPackage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp", line = 30,
 FQN="isInPackage", NM="_ZL11isInPackageRKN5clang4ento15CheckerRegistry11CheckerInfoEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp -nm=_ZL11isInPackageRKN5clang4ento15CheckerRegistry11CheckerInfoEN4llvm9StringRefE")
//</editor-fold>
public static boolean isInPackage(final /*const*/ CheckerRegistry.CheckerInfo /*&*/ checker, 
           StringRef packageName) {
  // Does the checker's full name have the package as a prefix?
  if (!checker.FullName.startswith(/*NO_COPY*/packageName)) {
    return false;
  }
  
  // Is the package actually just the name of a specific checker?
  if (checker.FullName.size() == packageName.size()) {
    return true;
  }
  
  // Is the checker in the package (or a subpackage)?
  if (checker.FullName.$at(packageName.size()) == PackageSeparator) {
    return true;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="collectCheckers">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp", line = 47,
 FQN="collectCheckers", NM="_ZL15collectCheckersRKSt6vectorIN5clang4ento15CheckerRegistry11CheckerInfoESaIS3_EERKN4llvm9StringMapIjNS8_15MallocAllocatorEEERNS1_14CheckerOptInfoERNS8_9SetVectorIPKS3_S_ISI_SaISI_EENS8_8DenseSetISI_NS8_12DenseMapInfoISI_EEEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp -nm=_ZL15collectCheckersRKSt6vectorIN5clang4ento15CheckerRegistry11CheckerInfoESaIS3_EERKN4llvm9StringMapIjNS8_15MallocAllocatorEEERNS1_14CheckerOptInfoERNS8_9SetVectorIPKS3_S_ISI_SaISI_EENS8_8DenseSetISI_NS8_12DenseMapInfoISI_EEEEEE")
//</editor-fold>
public static void collectCheckers(final /*const*/std.vector<CheckerRegistry.CheckerInfo> /*&*/ checkers, 
               final /*const*/StringMapUInt /*&*/ packageSizes, 
               final CheckerOptInfo /*&*/ opt, final SetVector</*const*/ CheckerRegistry.CheckerInfo /*P*/ > /*&*/ collected) {
  // Use a binary search to find the possible start of the package.
  CheckerRegistry.CheckerInfo packageInfo/*J*/= new CheckerRegistry.CheckerInfo((CheckerManager2Void)null, opt.getName(), new StringRef(/*KEEP_STR*/$EMPTY));
  std.vector.iterator</*const*/ CheckerRegistry.CheckerInfo> end = checkers.cend();
  std.vector.iterator</*const*/ CheckerRegistry.CheckerInfo /*P*/> i = std.lower_bound(checkers.cbegin(),
          new std.vector.iterator</*const*/ CheckerRegistry.CheckerInfo /*P*/>(end),
          packageInfo, /*FuncRef*/(CheckerRegistry.CheckerInfo one, CheckerRegistry.CheckerInfo other) -> checkerNameLT(one, other));
  
  // If we didn't even find a possible package, give up.
  if ($eq___normal_iterator$C(i, end)) {
    return;
  }
  
  // If what we found doesn't actually start the package, give up.
  if (!isInPackage(i.$star(), opt.getName())) {
    return;
  }
  
  // There is at least one checker in the package; claim the option.
  opt.claim();
  
  // See how large the package is.
  // If the package doesn't exist, assume the option refers to a single checker.
  /*size_t*/int size = 1;
  StringMapIteratorUInt packageSize = packageSizes.find$Const(opt.getName());
  if (packageSize.$noteq(packageSizes.end$Const())) {
    size = packageSize.$arrow().getValue$Const();
  }
  
  // Step through all the checkers in the package.
  for (std.vector.iterator</*const*/ CheckerRegistry.CheckerInfo /*P*/> checkEnd = i.$add(size); $noteq___normal_iterator$C(i, checkEnd); i.$preInc()) {
    if (opt.isEnabled()) {
      collected.insert($AddrOf(i.$star()));
    } else {
      collected.remove($AddrOf(i.$star()));
    }
  }
}

} // END OF class CheckerRegistryStatics

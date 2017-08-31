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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.ir.*;


/// Diagnostic information for stack size etc. reporting.
/// This is basically a function and a size.
//<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoResourceLimit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 165,
 FQN="llvm::DiagnosticInfoResourceLimit", NM="_ZN4llvm27DiagnosticInfoResourceLimitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm27DiagnosticInfoResourceLimitE")
//</editor-fold>
public class DiagnosticInfoResourceLimit extends /*public*/ DiagnosticInfo implements Destructors.ClassWithDestructor {
/*private:*/
  /// The function that is concerned by this resource limit diagnostic.
  private final /*const*/ Function /*&*/ Fn;

  /// Description of the resource type (e.g. stack size)
  private /*const*/char$ptr/*char P*/ ResourceName;

  /// The computed size usage
  private long/*uint64_t*/ ResourceSize;

  // Threshould passed
  private long/*uint64_t*/ ResourceLimit;
/*public:*/
  /// \p The function that is concerned by this stack size diagnostic.
  /// \p The computed stack size.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoResourceLimit::DiagnosticInfoResourceLimit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 182,
   FQN="llvm::DiagnosticInfoResourceLimit::DiagnosticInfoResourceLimit", NM="_ZN4llvm27DiagnosticInfoResourceLimitC1ERKNS_8FunctionEPKcyNS_18DiagnosticSeverityENS_14DiagnosticKindEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm27DiagnosticInfoResourceLimitC1ERKNS_8FunctionEPKcyNS_18DiagnosticSeverityENS_14DiagnosticKindEy")
  //</editor-fold>
  public DiagnosticInfoResourceLimit(final /*const*/ Function /*&*/ Fn,
      /*const*/char$ptr/*char P*/ ResourceName,
      long/*uint64_t*/ ResourceSize) {
    this(Fn,
      ResourceName,
      ResourceSize,
      DiagnosticSeverity.DS_Warning,
      DiagnosticKind.DK_ResourceLimit,
      $int2ulong(0));
  }
  public DiagnosticInfoResourceLimit(final /*const*/ Function /*&*/ Fn,
      /*const*/char$ptr/*char P*/ ResourceName,
      long/*uint64_t*/ ResourceSize,
      DiagnosticSeverity Severity/*= DS_Warning*/) {
    this(Fn,
      ResourceName,
      ResourceSize,
      Severity,
      DiagnosticKind.DK_ResourceLimit,
      $int2ulong(0));
  }
  public DiagnosticInfoResourceLimit(final /*const*/ Function /*&*/ Fn,
      /*const*/char$ptr/*char P*/ ResourceName,
      long/*uint64_t*/ ResourceSize,
      DiagnosticSeverity Severity/*= DS_Warning*/,
      DiagnosticKind Kind/*= DK_ResourceLimit*/) {
    this(Fn,
      ResourceName,
      ResourceSize,
      Severity,
      Kind,
      $int2ulong(0));
  }
  public DiagnosticInfoResourceLimit(final /*const*/ Function /*&*/ Fn,
      /*const*/char$ptr/*char P*/ ResourceName,
      long/*uint64_t*/ ResourceSize,
      DiagnosticSeverity Severity/*= DS_Warning*/,
      DiagnosticKind Kind/*= DK_ResourceLimit*/,
      long/*uint64_t*/ ResourceLimit/*= 0*/) {
    // : DiagnosticInfo(Kind, Severity), Fn(Fn), ResourceName(ResourceName), ResourceSize(ResourceSize), ResourceLimit(ResourceLimit)
    //START JInit
    super(Kind.getValue(), Severity);
    this./*&*/Fn=/*&*/Fn;
    this.ResourceName = $tryClone(ResourceName);
    this.ResourceSize = ResourceSize;
    this.ResourceLimit = ResourceLimit;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoResourceLimit::getFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 194,
   FQN="llvm::DiagnosticInfoResourceLimit::getFunction", NM="_ZNK4llvm27DiagnosticInfoResourceLimit11getFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm27DiagnosticInfoResourceLimit11getFunctionEv")
  //</editor-fold>
  public /*const*/ Function /*&*/ getFunction() /*const*/ {
    return Fn;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoResourceLimit::getResourceName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 195,
   FQN="llvm::DiagnosticInfoResourceLimit::getResourceName", NM="_ZNK4llvm27DiagnosticInfoResourceLimit15getResourceNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm27DiagnosticInfoResourceLimit15getResourceNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getResourceName() /*const*/ {
    return ResourceName;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoResourceLimit::getResourceSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 196,
   FQN="llvm::DiagnosticInfoResourceLimit::getResourceSize", NM="_ZNK4llvm27DiagnosticInfoResourceLimit15getResourceSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm27DiagnosticInfoResourceLimit15getResourceSizeEv")
  //</editor-fold>
  public long/*uint64_t*/ getResourceSize() /*const*/ {
    return ResourceSize;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoResourceLimit::getResourceLimit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 197,
   FQN="llvm::DiagnosticInfoResourceLimit::getResourceLimit", NM="_ZNK4llvm27DiagnosticInfoResourceLimit16getResourceLimitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm27DiagnosticInfoResourceLimit16getResourceLimitEv")
  //</editor-fold>
  public long/*uint64_t*/ getResourceLimit() /*const*/ {
    return ResourceLimit;
  }


  /// \see DiagnosticInfo::print.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoResourceLimit::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 115,
   FQN="llvm::DiagnosticInfoResourceLimit::print", NM="_ZNK4llvm27DiagnosticInfoResourceLimit5printERNS_17DiagnosticPrinterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm27DiagnosticInfoResourceLimit5printERNS_17DiagnosticPrinterE")
  //</editor-fold>
  @Override public void print(final DiagnosticPrinter /*&*/ DP) /*const*//* override*/ {
    DP.$out(getResourceName()).$out(/*KEEP_STR*/" limit");
    if (getResourceLimit() != $int2ullong(0)) {
      DP.$out(/*KEEP_STR*/" of ").$out_ullong(getResourceLimit());
    }

    DP.$out(/*KEEP_STR*/" exceeded (").$out_ullong(getResourceSize()).$out(/*KEEP_STR*/") in ").$out(getFunction());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoResourceLimit::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 202,
   FQN="llvm::DiagnosticInfoResourceLimit::classof", NM="_ZN4llvm27DiagnosticInfoResourceLimit7classofEPKNS_14DiagnosticInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm27DiagnosticInfoResourceLimit7classofEPKNS_14DiagnosticInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ DiagnosticInfo /*P*/ DI) {
    return DI.getKind() == DiagnosticKind.DK_ResourceLimit.getValue()
       || DI.getKind() == DiagnosticKind.DK_StackSize.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoResourceLimit::~DiagnosticInfoResourceLimit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 165,
   FQN="llvm::DiagnosticInfoResourceLimit::~DiagnosticInfoResourceLimit", NM="_ZN4llvm27DiagnosticInfoResourceLimitD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm27DiagnosticInfoResourceLimitD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + "Fn=" + Fn // NOI18N
              + ", ResourceName=" + ResourceName // NOI18N
              + ", ResourceSize=" + ResourceSize // NOI18N
              + ", ResourceLimit=" + ResourceLimit // NOI18N
              + super.toString(); // NOI18N
  }
}

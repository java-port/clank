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

package org.clang.basic.java;

import org.clang.basic.PartialDiagnostic;
import org.clang.basic.SourceLocation;
import org.clank.java.std;
import org.clank.java.std_pair;
import org.clank.support.Converted;
import org.clank.support.JavaDifferentiators.JD$Move;
import org.clank.support.JavaDifferentiators.JD$UInt_T$C$R;
import org.llvm.adt.aliases.SmallVector;

/**
 * typedef SmallVector<PartialDiagnosticAt, 1> OptionalNotes;
typedef std::pair<PartialDiagnosticAt, OptionalNotes> DelayedDiag;
typedef std::list<DelayedDiag> DiagList;
 * @author Vladimir Voskresensky
 */
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::warnLockMismatch">
@Converted(kind = Converted.Kind.MANUAL_ADDED, source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1449)
//</editor-fold>
public class OptionalNotes extends SmallVector<std.pairTypeType<SourceLocation, PartialDiagnostic>> {
  public static final std_pair.pairTypeType<SourceLocation, PartialDiagnostic> DEFAULT_PartialDiagnosticAt = new std.pairTypeType<SourceLocation, PartialDiagnostic>(new SourceLocation(), new PartialDiagnostic(new PartialDiagnostic.NullDiagnostic()));
  public static final OptionalNotes DEFAULT = new OptionalNotes();
  
  public OptionalNotes() {
    this(1, DEFAULT_PartialDiagnosticAt);
  }
  
  public OptionalNotes(int capacity) {
    super(capacity, DEFAULT_PartialDiagnosticAt);
  }
  
  public OptionalNotes(int capacity, std.pairTypeType<SourceLocation, PartialDiagnostic> defaultValue) {
    // we skip passed default and pass own, because JConvert sometimes has incompletely initialized default
    super(capacity, DEFAULT_PartialDiagnosticAt);
  }

  public OptionalNotes(JD$UInt_T$C$R _dparm, int capacity, int NumElements, std.pairTypeType<SourceLocation, PartialDiagnostic> Element) {
    super(_dparm, capacity, NumElements, Element, DEFAULT_PartialDiagnosticAt);
  }
  
  public OptionalNotes(SmallVector<std.pairTypeType<SourceLocation, PartialDiagnostic>> $Prm0) {
    super($Prm0);
    assert !$Prm0.isDataPointerLike();
  }

  public OptionalNotes(JD$Move _dparm, SmallVector<std.pairTypeType<SourceLocation, PartialDiagnostic>> $Prm0) {
    super(_dparm, $Prm0);
    assert !$Prm0.isDataPointerLike();
  }

  @Override
  public SmallVector<std_pair.pairTypeType<SourceLocation, PartialDiagnostic>> clone() {
    return new OptionalNotes(this);
  }

  @Override
  public SmallVector<std_pair.pairTypeType<SourceLocation, PartialDiagnostic>> move() {
    return new OptionalNotes(JD$Move.INSTANCE, this);
  }
  
}

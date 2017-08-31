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

package org.clang.tools.services.impl;

import org.clang.basic.FixItHint;
import static org.clang.basic.JavaBasicGlobals.$second_offset;
import org.clang.basic.LangOptions;
import org.clang.basic.SourceLocation;
import org.clang.basic.SourceManager;
import org.clang.lex.Lexer;
import org.clang.tools.services.ClankDiagnosticEnhancedFix;

/**
 *
 * @author masha
 */
public class ClankDiagnosticEnhancedFixImpl implements ClankDiagnosticEnhancedFix{
//  private final FixItHint fixItHint;
//  private final SourceManager SM;
  private final String text;
  private final int removeStartOffset;
  private final int removeEndOffset;
  private final int insertStartOffset;
  private final int insertEndOffset;
  private final String textToInsert;
  private final boolean isRemoveTokenRange;
  private final boolean  isInsertRangeValid;
  private final boolean beforePreviousInsertions;  
  
  
  ClankDiagnosticEnhancedFixImpl(String text, SourceManager SM, LangOptions /*&*/ LangOpts, FixItHint fixItHint) {
//    this.fixItHint = fixItHint;
//    this.SM = SM;
    this.text = text;
    this.textToInsert = fixItHint.CodeToInsert.toJavaString();
    SourceLocation removeStartLoc = fixItHint.RemoveRange.getBegin();
    long/*<FileID, uint>*/ decomposedLocBegin = SM.getDecomposedLoc(removeStartLoc.getRawEncoding());
    removeStartOffset = $second_offset(decomposedLocBegin);
    SourceLocation removeEndLoc = fixItHint.RemoveRange.getEnd();
     long/*<FileID, uint>*/ decomposedLocEnd = SM.getDecomposedLoc(removeEndLoc.getRawEncoding());
    int removeEndOffset_ = $second_offset(decomposedLocEnd);
    SourceLocation insertStartLoc = fixItHint.InsertFromRange.getBegin();
    long/*<FileID, uint>*/ decomposedInsertLocBegin = SM.getDecomposedLoc(insertStartLoc.getRawEncoding());
    insertStartOffset = $second_offset(decomposedInsertLocBegin);    
    SourceLocation insertEndLoc = fixItHint.InsertFromRange.getEnd();
     long/*<FileID, uint>*/ decomposedInsertLocEnd = SM.getDecomposedLoc(insertEndLoc.getRawEncoding());
    insertEndOffset = $second_offset(decomposedInsertLocEnd);          
    isInsertRangeValid = fixItHint.InsertFromRange.isValid();
    isRemoveTokenRange = fixItHint.RemoveRange.isTokenRange();
    if (isRemoveTokenRange) {
        removeEndOffset_ +=  Lexer.MeasureTokenLength(removeEndLoc, SM, LangOpts);
    }
    removeEndOffset = removeEndOffset_;
    beforePreviousInsertions = fixItHint.BeforePreviousInsertions;
  }

  @Override
  public String getText() {
    return text;
  }

//  @Override
//  public ClankDiagnosticChangeInfo implement() {
//    System.out.println("I am here:::::::::::::::::::;; FIX IT");
//    return null;
//  }

  @Override
  public int getRemoveStartOffset() {
    return removeStartOffset;
  }

  @Override
  public int getRemoveEndOffset() {
    return removeEndOffset;
  }

  @Override
  public String getInsertionText() {
    return  textToInsert;
  }

  @Override
  public int getInsertStartOffset() {
    return insertStartOffset;
  }

  @Override
  public int getInsertEndOffset() {
    return insertEndOffset;

  }

  @Override
  public boolean isRemoveTokenRange() {
    return isRemoveTokenRange;
  }

  @Override
  public boolean isInsertRangeValid() {
    return isInsertRangeValid;
  }

  @Override
  public boolean beforePreviousInsertions() {
    return beforePreviousInsertions;
  }
  
}

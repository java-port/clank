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

package org.clang.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.frontend.*;


/// \brief A source location that has been parsed on the command line.
//<editor-fold defaultstate="collapsed" desc="clang::ParsedSourceLocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CommandLineSourceLoc.h", line = 25,
 FQN="clang::ParsedSourceLocation", NM="_ZN5clang20ParsedSourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang20ParsedSourceLocationE")
//</editor-fold>
public class/*struct*/ ParsedSourceLocation implements Destructors.ClassWithDestructor {
  public std.string FileName;
  public /*uint*/int Line;
  public /*uint*/int Column;
/*public:*/
  /// Construct a parsed source location from a string; the Filename is empty on
  /// error.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedSourceLocation::FromString">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CommandLineSourceLoc.h", line = 33,
   FQN="clang::ParsedSourceLocation::FromString", NM="_ZN5clang20ParsedSourceLocation10FromStringEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang20ParsedSourceLocation10FromStringEN4llvm9StringRefE")
  //</editor-fold>
  public static ParsedSourceLocation FromString(StringRef Str) {
    ParsedSourceLocation PSL/*J*/= new ParsedSourceLocation();
    std.pair<StringRef, StringRef> ColSplit = Str.rsplit($$COLON);
    std.pair<StringRef, StringRef> LineSplit = ColSplit.first.rsplit($$COLON);
    
    uint$ref PSL$Column = new uint$ref() {
      @Override public int $deref() { return PSL.Column; }
      @Override public int $set(int value) { return PSL.Column = value; }
    };
    uint$ref PSL$Line = new uint$ref() {
      @Override public int $deref() { return PSL.Line; }
      @Override public int $set(int value) { return PSL.Line = value; }
    };
    // If both tail splits were valid integers, return success.
    if (!ColSplit.second.getAsInteger$NotSigned(10, PSL$Column)
       && !LineSplit.second.getAsInteger$NotSigned(10, PSL$Line)) {
      PSL.FileName.$assignMove(LineSplit.first.$string());
      
      // On the command-line, stdin may be specified via "-". Inside the
      // compiler, stdin is called "<stdin>".
      if ($eq_string$C_T$C$P(PSL.FileName, /*KEEP_STR*/"-")) {
        PSL.FileName.$assign_T$C$P(/*KEEP_STR*/"<stdin>");
      }
    }
    
    return PSL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParsedSourceLocation::ParsedSourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CommandLineSourceLoc.h", line = 25,
   FQN="clang::ParsedSourceLocation::ParsedSourceLocation", NM="_ZN5clang20ParsedSourceLocationC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang20ParsedSourceLocationC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ParsedSourceLocation(/*const*/ ParsedSourceLocation /*&*/ $Prm0) {
    // : FileName(.FileName), Line(.Line), Column(.Column) 
    //START JInit
    this.FileName = new std.string($Prm0.FileName);
    this.Line = $Prm0.Line;
    this.Column = $Prm0.Column;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParsedSourceLocation::ParsedSourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CommandLineSourceLoc.h", line = 25,
   FQN="clang::ParsedSourceLocation::ParsedSourceLocation", NM="_ZN5clang20ParsedSourceLocationC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang20ParsedSourceLocationC1EOS0_")
  //</editor-fold>
  public /*inline*/ ParsedSourceLocation(JD$Move _dparam, ParsedSourceLocation /*&&*/$Prm0) {
    // : FileName(static_cast<ParsedSourceLocation &&>().FileName), Line(static_cast<ParsedSourceLocation &&>().Line), Column(static_cast<ParsedSourceLocation &&>().Column) 
    //START JInit
    this.FileName = new std.string(JD$Move.INSTANCE, $Prm0.FileName);
    this.Line = $Prm0.Line;
    this.Column = $Prm0.Column;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParsedSourceLocation::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CommandLineSourceLoc.h", line = 25,
   FQN="clang::ParsedSourceLocation::operator=", NM="_ZN5clang20ParsedSourceLocationaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang20ParsedSourceLocationaSEOS0_")
  //</editor-fold>
  public /*inline*/ ParsedSourceLocation /*&*/ $assignMove(ParsedSourceLocation /*&&*/$Prm0) {
    this.FileName.$assignMove($Prm0.FileName);
    this.Line = $Prm0.Line;
    this.Column = $Prm0.Column;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParsedSourceLocation::~ParsedSourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CommandLineSourceLoc.h", line = 25,
   FQN="clang::ParsedSourceLocation::~ParsedSourceLocation", NM="_ZN5clang20ParsedSourceLocationD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang20ParsedSourceLocationD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    FileName.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParsedSourceLocation::ParsedSourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CommandLineSourceLoc.h", line = 25,
   FQN="clang::ParsedSourceLocation::ParsedSourceLocation", NM="_ZN5clang20ParsedSourceLocationC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang20ParsedSourceLocationC1Ev")
  //</editor-fold>
  public /*inline*/ ParsedSourceLocation() {
    // : FileName() 
    //START JInit
    this.FileName = new std.string();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "FileName=" + FileName // NOI18N
              + ", Line=" + Line // NOI18N
              + ", Column=" + Column; // NOI18N
  }
}

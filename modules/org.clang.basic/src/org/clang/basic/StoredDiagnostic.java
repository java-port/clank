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

package org.clang.basic;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


/**
* \brief Represents a diagnostic in a form that can be retained until its 
* corresponding source manager is destroyed. 
*/
//<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1264,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1257,
 FQN="clang::StoredDiagnostic", NM="_ZN5clang16StoredDiagnosticE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang16StoredDiagnosticE")
//</editor-fold>
public class StoredDiagnostic implements Destructors.ClassWithDestructor, Native.Native$Bool, NativeCloneable<StoredDiagnostic>, NativeMoveable<StoredDiagnostic>  {
  private /*uint*/int ID;
  private DiagnosticsEngine.Level Level;
  private final FullSourceLoc Loc;
  private final std.string Message;
  private final std.vector<CharSourceRange> Ranges;
  private final std.vector<FixItHint> FixIts;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::StoredDiagnostic">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1273,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1266,
   FQN="clang::StoredDiagnostic::StoredDiagnostic", NM="_ZN5clang16StoredDiagnosticC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang16StoredDiagnosticC1Ev")
  //</editor-fold>
  public StoredDiagnostic()/* = default*/ {
    /*<<<defaulted constructor: may be there is another TU where objects are created?>>>*/
    //START JInit
    this.Loc = new FullSourceLoc();
    this.Message = new std.string();
    this.Ranges = new std.vector<CharSourceRange>(new CharSourceRange());
    this.FixIts = new std.vector<FixItHint>(new FixItHint());
    //END JInit    
  }


  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::StoredDiagnostic">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 953,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 952,
   FQN="clang::StoredDiagnostic::StoredDiagnostic", NM="_ZN5clang16StoredDiagnosticC1ENS_17DiagnosticsEngine5LevelERKNS_10DiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang16StoredDiagnosticC1ENS_17DiagnosticsEngine5LevelERKNS_10DiagnosticE")
  //</editor-fold>
  public StoredDiagnostic(DiagnosticsEngine.Level Level, 
      /*const*/ Diagnostic /*&*/ Info) {
    /* : ID(Info.getID()), Level(Level), Loc(), Message(), Ranges(), FixIts()*/ 
    //START JInit
    this.ID = Info.getID();
    this.Level = Level;
    this.Loc = new FullSourceLoc();
    this.Message = new std.string();
    this.Ranges = new std.vector<CharSourceRange>(new CharSourceRange());
    this.FixIts = new std.vector<FixItHint>(new FixItHint());
    //END JInit
    assert ((Info.getLocation().isInvalid() || Info.hasSourceManager())) : "Valid source location without setting a source manager for diagnostic";
    if (Info.getLocation().isValid()) {
      Loc.$assignMove(new FullSourceLoc(/*NO_COPY*/Info.getLocation(), Info.getSourceManager()));
    }
    SmallString/*64*/ Message/*J*/= new SmallString/*64*/(64);
    Info.FormatDiagnostic(Message);
    if (true) {
      this.Message.assign$T(Message.begin(), Message.end());
      this.Ranges.assign$T(Info.getRanges().begin(), Info.getRanges().end());
      this.FixIts.assign$T(Info.getFixItHints().begin(), Info.getFixItHints().end());
    } else {// JAVA PERF?
      this.Message.reserve(Message.size());
      for (/*uint*/int I = 0, N = Message.size(); I != N; ++I)  {
        Message.push_back(Message.$at(I));
      }
      
      Ranges.reserve(Info.getNumRanges());
      for (/*uint*/int I = 0, N = Info.getNumRanges(); I != N; ++I)  {
        Ranges.push_back(Info.getRange(I));
      }

      FixIts.reserve(Info.getNumFixItHints());
      for (/*uint*/int I = 0, N = Info.getNumFixItHints(); I != N; ++I)  {
        FixIts.push_back(Info.getFixItHint(I));
      }    
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::StoredDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 949,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 948,
   FQN="clang::StoredDiagnostic::StoredDiagnostic", NM="_ZN5clang16StoredDiagnosticC1ENS_17DiagnosticsEngine5LevelEjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang16StoredDiagnosticC1ENS_17DiagnosticsEngine5LevelEjN4llvm9StringRefE")
  //</editor-fold>
  public StoredDiagnostic(DiagnosticsEngine.Level Level, /*uint*/int ID, 
      StringRef Message) {
    /* : ID(ID), Level(Level), Loc(), Message(Message.operator basic_string()), Ranges(), FixIts()*/ 
    //START JInit
    this.ID = ID;
    this.Level = Level;
    this.Loc = new FullSourceLoc();
    this.Message = Message.$string();
    this.Ranges = new std.vector<CharSourceRange>(new CharSourceRange());
    this.FixIts = new std.vector<FixItHint>(new FixItHint());
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::StoredDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 968,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 967,
   FQN="clang::StoredDiagnostic::StoredDiagnostic", NM="_ZN5clang16StoredDiagnosticC1ENS_17DiagnosticsEngine5LevelEjN4llvm9StringRefENS_13FullSourceLocENS3_8ArrayRefINS_15CharSourceRangeEEENS6_INS_9FixItHintEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang16StoredDiagnosticC1ENS_17DiagnosticsEngine5LevelEjN4llvm9StringRefENS_13FullSourceLocENS3_8ArrayRefINS_15CharSourceRangeEEENS6_INS_9FixItHintEEE")
  //</editor-fold>
  public StoredDiagnostic(DiagnosticsEngine.Level Level, /*uint*/int ID, 
      StringRef Message, FullSourceLoc Loc, 
      ArrayRef<CharSourceRange> Ranges, 
      ArrayRef<FixItHint> FixIts) {
    /* : ID(ID), Level(Level), Loc(Loc), Message(Message.operator basic_string()), Ranges(Ranges.begin(), Ranges.end()), FixIts(FixIts.begin(), FixIts.end())*/ 
    //START JInit
    this.ID = ID;
    this.Level = Level;
    this.Loc = new FullSourceLoc(Loc);
    this.Message = Message.$string();
    this.Ranges = new std.vector<CharSourceRange>(Ranges.begin(), Ranges.end(), new CharSourceRange());
    this.FixIts = new std.vector<FixItHint>(FixIts.begin(), FixIts.end(), new FixItHint());
    //END JInit
  }


  
  /// \brief Evaluates true when this object stores a diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1283,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1276,
   FQN="clang::StoredDiagnostic::operator bool", NM="_ZNK5clang16StoredDiagnosticcvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang16StoredDiagnosticcvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return $greater_uint(Message.size(), 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::getID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1285,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1278,
   FQN="clang::StoredDiagnostic::getID", NM="_ZNK5clang16StoredDiagnostic5getIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang16StoredDiagnostic5getIDEv")
  //</editor-fold>
  public /*uint*/int getID() /*const*/ {
    return ID;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::getLevel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1286,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1279,
   FQN="clang::StoredDiagnostic::getLevel", NM="_ZNK5clang16StoredDiagnostic8getLevelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang16StoredDiagnostic8getLevelEv")
  //</editor-fold>
  public DiagnosticsEngine.Level getLevel() /*const*/ {
    return Level;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1287,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1280,
   FQN="clang::StoredDiagnostic::getLocation", NM="_ZNK5clang16StoredDiagnostic11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang16StoredDiagnostic11getLocationEv")
  //</editor-fold>
  public /*const*/ FullSourceLoc /*&*/ getLocation() /*const*/ {
    return Loc;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::getMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1288,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1281,
   FQN="clang::StoredDiagnostic::getMessage", NM="_ZNK5clang16StoredDiagnostic10getMessageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang16StoredDiagnostic10getMessageEv")
  //</editor-fold>
  public StringRef getMessage() /*const*/ {
    return new StringRef(Message);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::setLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1290,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1283,
   FQN="clang::StoredDiagnostic::setLocation", NM="_ZN5clang16StoredDiagnostic11setLocationENS_13FullSourceLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang16StoredDiagnostic11setLocationENS_13FullSourceLocE")
  //</editor-fold>
  public void setLocation(FullSourceLoc Loc) {
    this.Loc.$assign(Loc);
  }

  
  /*typedef std::vector<CharSourceRange>::const_iterator range_iterator*/
//  public final class range_iterator extends std.vector.iterator<CharSourceRange>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::range_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1293,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1286,
   FQN="clang::StoredDiagnostic::range_begin", NM="_ZNK5clang16StoredDiagnostic11range_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang16StoredDiagnostic11range_beginEv")
  //</editor-fold>
  public std.vector.iterator<CharSourceRange> range_begin() /*const*/ {
    return Ranges.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::range_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1294,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1287,
   FQN="clang::StoredDiagnostic::range_end", NM="_ZNK5clang16StoredDiagnostic9range_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang16StoredDiagnostic9range_endEv")
  //</editor-fold>
  public std.vector.iterator<CharSourceRange> range_end() /*const*/ {
    return Ranges.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::range_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1295,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1288,
   FQN="clang::StoredDiagnostic::range_size", NM="_ZNK5clang16StoredDiagnostic10range_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang16StoredDiagnostic10range_sizeEv")
  //</editor-fold>
  public /*uint*/int range_size() /*const*/ {
    return Ranges.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::getRanges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1297,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1290,
   FQN="clang::StoredDiagnostic::getRanges", NM="_ZNK5clang16StoredDiagnostic9getRangesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang16StoredDiagnostic9getRangesEv")
  //</editor-fold>
  public ArrayRef<CharSourceRange> getRanges() /*const*/ {
    return llvm.makeArrayRef(Ranges);
  }

  
  /*typedef std::vector<FixItHint>::const_iterator fixit_iterator*/
//  public final class fixit_iterator extends std.vector.iterator<FixItHint>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::fixit_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1303,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1296,
   FQN="clang::StoredDiagnostic::fixit_begin", NM="_ZNK5clang16StoredDiagnostic11fixit_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang16StoredDiagnostic11fixit_beginEv")
  //</editor-fold>
  public std.vector.iterator<FixItHint> fixit_begin() /*const*/ {
    return FixIts.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::fixit_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1304,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1297,
   FQN="clang::StoredDiagnostic::fixit_end", NM="_ZNK5clang16StoredDiagnostic9fixit_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang16StoredDiagnostic9fixit_endEv")
  //</editor-fold>
  public std.vector.iterator<FixItHint> fixit_end() /*const*/ {
    return FixIts.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::fixit_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1305,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1298,
   FQN="clang::StoredDiagnostic::fixit_size", NM="_ZNK5clang16StoredDiagnostic10fixit_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang16StoredDiagnostic10fixit_sizeEv")
  //</editor-fold>
  public /*uint*/int fixit_size() /*const*/ {
    return FixIts.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::getFixIts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1307,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1300,
   FQN="clang::StoredDiagnostic::getFixIts", NM="_ZNK5clang16StoredDiagnostic9getFixItsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang16StoredDiagnostic9getFixItsEv")
  //</editor-fold>
  public ArrayRef<FixItHint> getFixIts() /*const*/ {
    return llvm.makeArrayRef(FixIts);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::StoredDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1264,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1257,
   FQN="clang::StoredDiagnostic::StoredDiagnostic", NM="_ZN5clang16StoredDiagnosticC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang16StoredDiagnosticC1ERKS0_")
  //</editor-fold>
  public /*inline*/ StoredDiagnostic(/*const*/ StoredDiagnostic /*&*/ $Prm0) {
    /* : ID(.ID), Level(.Level), Loc(.Loc), Message(.Message), Ranges(.Ranges), FixIts(.FixIts)*/ 
    //START JInit
    this.ID = $Prm0.ID;
    this.Level = $Prm0.Level;
    this.Loc = new FullSourceLoc($Prm0.Loc);
    this.Message = new std.string($Prm0.Message);
    this.Ranges = new std.vector<CharSourceRange>($Prm0.Ranges);
    this.FixIts = new std.vector<FixItHint>($Prm0.FixIts);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::StoredDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1264,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1257,
   FQN="clang::StoredDiagnostic::StoredDiagnostic", NM="_ZN5clang16StoredDiagnosticC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang16StoredDiagnosticC1EOS0_")
  //</editor-fold>
  public /*inline*/ StoredDiagnostic(JD$Move _dparam, StoredDiagnostic /*&&*/$Prm0) {
    /* : ID(static_cast<StoredDiagnostic &&>().ID), Level(static_cast<StoredDiagnostic &&>().Level), Loc(static_cast<StoredDiagnostic &&>().Loc), Message(static_cast<StoredDiagnostic &&>().Message), Ranges(static_cast<StoredDiagnostic &&>().Ranges), FixIts(static_cast<StoredDiagnostic &&>().FixIts)*/ 
    //START JInit
    this.ID = $Prm0.ID;
    this.Level = $Prm0.Level;
    this.Loc = new FullSourceLoc(JD$Move.INSTANCE, $Prm0.Loc);
    this.Message = new std.string(JD$Move.INSTANCE, $Prm0.Message);
    this.Ranges = new std.vector<CharSourceRange>(JD$Move.INSTANCE, $Prm0.Ranges);
    this.FixIts = new std.vector<FixItHint>(JD$Move.INSTANCE, $Prm0.FixIts);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1264,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1257,
   FQN="clang::StoredDiagnostic::operator=", NM="_ZN5clang16StoredDiagnosticaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang16StoredDiagnosticaSEOS0_")
  //</editor-fold>
  public /*inline*/ StoredDiagnostic /*&*/ $assignMove(StoredDiagnostic /*&&*/$Prm0) {
    this.ID = $Prm0.ID;
    this.Level = $Prm0.Level;
    this.Loc.$assignMove($Prm0.Loc);
    this.Message.$assignMove($Prm0.Message);
    this.Ranges.$assignMove($Prm0.Ranges);
    this.FixIts.$assignMove($Prm0.FixIts);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StoredDiagnostic::~StoredDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1264,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1257,
   FQN="clang::StoredDiagnostic::~StoredDiagnostic", NM="_ZN5clang16StoredDiagnosticD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang16StoredDiagnosticD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    FixIts.$destroy();
    Ranges.$destroy();
    Message.$destroy();
    //END JDestroy
  }

  @Override public StoredDiagnostic clone() {
    return new StoredDiagnostic(this);
  }
  
  @Override public StoredDiagnostic move() {
    return new StoredDiagnostic(JD$Move.INSTANCE, this);
  }
  
  
  public String toString() {
    return "" + "ID=" + ID // NOI18N
              + ", Level=" + Level // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", Message=" + Message // NOI18N
              + ", Ranges=" + Ranges // NOI18N
              + ", FixIts=" + FixIts; // NOI18N
  }
}

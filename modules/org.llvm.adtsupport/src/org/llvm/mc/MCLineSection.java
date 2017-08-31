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

package org.llvm.mc;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.aliases.*;


/// \brief Instances of this class represent the line information for a compile
/// unit where machine instructions have been assembled after seeing .loc
/// directives.  This is the information used to build the dwarf line
/// table for a section.
//<editor-fold defaultstate="collapsed" desc="llvm::MCLineSection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 160,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 162,
 FQN="llvm::MCLineSection", NM="_ZN4llvm13MCLineSectionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm13MCLineSectionE")
//</editor-fold>
public class MCLineSection implements Destructors.ClassWithDestructor {
/*public:*/
  // \brief Add an entry to this MCLineSection's line entries.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLineSection::addLineEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 163,
   FQN="llvm::MCLineSection::addLineEntry", NM="_ZN4llvm13MCLineSection12addLineEntryERKNS_16MCDwarfLineEntryEPNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm13MCLineSection12addLineEntryERKNS_16MCDwarfLineEntryEPNS_9MCSectionE")
  //</editor-fold>
  public void addLineEntry(final /*const*/ MCDwarfLineEntry /*&*/ LineEntry, MCSection /*P*/ Sec) {
    MCLineDivisions.$at(Sec).push_back_T$C$R(LineEntry);
  }

  
  // JAVA: typedef std::vector<MCDwarfLineEntry> MCDwarfLineEntryCollection
//  public final class MCDwarfLineEntryCollection extends std.vector<MCDwarfLineEntry>{ };
  // JAVA: typedef MCDwarfLineEntryCollection::iterator iterator
//  public final class iterator extends std.vector.iterator<MCDwarfLineEntry /*P*/ >{ };
  // JAVA: typedef MCDwarfLineEntryCollection::const_iterator const_iterator
//  public final class const_iterator extends std.vector.iterator</*const*/ MCDwarfLineEntry /*P*/ >{ };
  // JAVA: typedef MapVector<MCSection *, MCDwarfLineEntryCollection> MCLineDivisionMap
//  public final class MCLineDivisionMap extends MapVector<MCSection /*P*/ , std.vector<MCDwarfLineEntry> >{ };
/*private:*/
  // A collection of MCDwarfLineEntry for each section.
  private MapVectorPtrType<MCSection /*P*/ , std.vector<MCDwarfLineEntry> > MCLineDivisions;
/*public:*/
  // Returns the collection of MCDwarfLineEntry for a given Compile Unit ID.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLineSection::getMCLineEntries">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 178,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 180,
   FQN="llvm::MCLineSection::getMCLineEntries", NM="_ZNK4llvm13MCLineSection16getMCLineEntriesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZNK4llvm13MCLineSection16getMCLineEntriesEv")
  //</editor-fold>
  public /*const*/ MapVectorPtrType<MCSection /*P*/ , std.vector<MCDwarfLineEntry> > /*&*/ getMCLineEntries() /*const*/ {
    return MCLineDivisions;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCLineSection::~MCLineSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 160,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 162,
   FQN="llvm::MCLineSection::~MCLineSection", NM="_ZN4llvm13MCLineSectionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm13MCLineSectionD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    MCLineDivisions.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCLineSection::MCLineSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 160,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 162,
   FQN="llvm::MCLineSection::MCLineSection", NM="_ZN4llvm13MCLineSectionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm13MCLineSectionC1Ev")
  //</editor-fold>
  public /*inline*/ MCLineSection() {
    // : MCLineDivisions() 
    //START JInit
    this.MCLineDivisions = new MapVectorPtrType<MCSection /*P*/ , std.vector<MCDwarfLineEntry> >(DenseMapInfo$LikePtr.$Info(), new std.vector<MCDwarfLineEntry>(new MCDwarfLineEntry()));
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "MCLineDivisions=" + MCLineDivisions; // NOI18N
  }
}
